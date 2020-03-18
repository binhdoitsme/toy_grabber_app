package com.toygrabber.base.requesthandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class RequestHandlerChain implements RequestHandler<Request, Response> {
	private Collection<RequestHandler<Request, Response>> handlers;

	public RequestHandlerChain beginWith(RequestHandler<Request, Response> handler) {
		handlers = new ArrayList<>();
		handlers.add(handler);
		return this;
	}

	public RequestHandlerChain thenWith(RequestHandler<Request, Response> handler) {
		handlers.add(handler);
		return this;
	}

	@Override
	public <T extends Request> Response handle(T input) {
		Iterator<RequestHandler<Request, Response>> iterator = this.handlers.iterator();
		Request request = input;
		Response response = null;
		while (iterator.hasNext()) {
			response = iterator.next().handle(request);
			request = (Request) response;
		}
		return response;
	}
}
