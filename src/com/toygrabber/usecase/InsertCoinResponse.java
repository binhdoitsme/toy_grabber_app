package com.toygrabber.usecase;

import com.toygrabber.common.Response;

public class InsertCoinResponse implements Response {
	private int numOfTurns;
	
	public InsertCoinResponse(int numOfTurns) {
		this.numOfTurns = numOfTurns;
	}
	
	public int getNumOfTurns() {
		return this.numOfTurns;
	}
}
