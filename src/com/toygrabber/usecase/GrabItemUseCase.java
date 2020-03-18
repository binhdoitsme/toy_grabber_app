package com.toygrabber.usecase;

import java.util.Collection;

import com.toygrabber.common.Request;
import com.toygrabber.common.RequestHandler;
import com.toygrabber.common.Response;
import com.toygrabber.domain.Item;

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
