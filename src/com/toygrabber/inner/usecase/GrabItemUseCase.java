package com.toygrabber.inner.usecase;

import java.util.Collection;

import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.base.requesthandler.RequestHandler;
import com.toygrabber.base.requesthandler.Response;
import com.toygrabber.inner.domain.Item;

public class GrabItemUseCase implements RequestHandler<Request, Response> {
	
	@Override
	public <T extends Request> Response handle(T input) {
		return handle((GrabItemRequest) input);
	}
	
	public Response handle(GrabItemRequest input) {
		Collection<Item> result = input.getEvent().getResult();
		return new GrabItemResponse(result);
	}

}
