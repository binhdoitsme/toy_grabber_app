package com.toygrabber.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString @EqualsAndHashCode @Getter
public final class Coin {
	private static final float VALUE = 0.5f;
	
	public static float getValue() {
		return VALUE;
	}
}
