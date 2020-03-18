package com.toygrabber.usecase;

import com.toygrabber.common.Request;
import com.toygrabber.common.RequestHandler;
import com.toygrabber.common.Response;

public class PlaceClawUseCase implements RequestHandler<Request, Response> {
	@Override
	public <T extends Request> Response handle(T request) {
		return handle((PlaceClawRequest)request);
	}
	
	private Response handle(PlaceClawRequest request) {
		return new PlaceClawResponse(request.getRequestCoordinates());
	}
}
