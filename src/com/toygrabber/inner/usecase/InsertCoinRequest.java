package com.toygrabber.inner.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.base.datatransfer.DataTransfer;
import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.inner.datatransfer.InsertedCoinsDto;
import com.toygrabber.inner.domain.Coin;

public class InsertCoinRequest implements Request {
	private Collection<Coin> insertedCoins;

	public InsertCoinRequest(DataTransfer insertedCoinsDto) {
		Collection<Coin> insertedCoins = ((InsertedCoinsDto)insertedCoinsDto).getInsertedCoins();
		this.insertedCoins = new ArrayList<Coin>(insertedCoins);
	}

	private int calculateNumOfTurns(int numOfCoins, float coinValue) {
		return (int) ((float) numOfCoins * coinValue);
	}
	
	public int getNumOfTurns() {
		return calculateNumOfTurns(insertedCoins.size(), Coin.getValue());
	}
}
