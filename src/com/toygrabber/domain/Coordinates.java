package com.toygrabber.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE) @Getter @ToString @EqualsAndHashCode
public class Coordinates {
	private @NonNull Integer x;
	private @NonNull Integer y;
	
	public static Coordinates from(int x, int y) {
		return new Coordinates(x, y);
	}
}
