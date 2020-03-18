package com.toygrabber.inner.usecase;

import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.base.requesthandler.RequestHandler;
import com.toygrabber.base.requesthandler.Response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InsertCoinUseCase implements RequestHandler<Request, Response> {

	private Response handle(InsertCoinRequest request) {
		return new InsertCoinResponse(request.getNumOfTurns());
	}

	@Override
	public <T extends Request> Response handle(T request) {
		return handle((InsertCoinRequest) request);
	}
	
}
