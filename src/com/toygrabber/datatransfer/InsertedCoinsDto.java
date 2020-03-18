package com.toygrabber.datatransfer;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.DataTransfer;
import com.toygrabber.domain.Coin;

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
