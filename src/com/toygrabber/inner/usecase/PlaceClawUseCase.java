package com.toygrabber.inner.usecase;

import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.base.requesthandler.RequestHandler;
import com.toygrabber.base.requesthandler.Response;

public class PlaceClawUseCase implements RequestHandler<Request, Response> {
	@Override
	public <T extends Request> Response handle(T request) {
		return handle((PlaceClawRequest)request);
	}
	
	private Response handle(PlaceClawRequest request) {
		return new PlaceClawResponse(request.getRequestCoordinates());
	}
}
