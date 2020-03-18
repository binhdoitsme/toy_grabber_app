package com.toygrabber.usecase;

import com.toygrabber.common.Request;
import com.toygrabber.common.RequestHandler;
import com.toygrabber.common.Response;

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
