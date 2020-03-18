package com.toygrabber.inner.datatransfer;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.base.datatransfer.DataTransfer;
import com.toygrabber.inner.domain.Coin;

import lombok.Getter;

@Getter
public class InsertedCoinsDto extends DataTransfer {
	private Collection<Coin> insertedCoins;
	
	public InsertedCoinsDto(int coinCnt) {
		insertedCoins = new ArrayList<>(coinCnt);
		fill(insertedCoins, new Coin(), coinCnt);
	}
	
	<T> void fill(Collection<T> source, T itemToFill, int count) {
		for (int i = 0; i < count; i++) {
			source.add(itemToFill);
		}
	}
}
