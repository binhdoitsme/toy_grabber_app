package com.toygrabber.inner.usecase;

import com.toygrabber.base.requesthandler.Response;

public class InsertCoinResponse implements Response {
	private int numOfTurns;
	
	public InsertCoinResponse(int numOfTurns) {
		this.numOfTurns = numOfTurns;
	}
	
	public int getNumOfTurns() {
		return this.numOfTurns;
	}
}
