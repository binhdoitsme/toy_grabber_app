package com.toygrabber.inner.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor @Getter @Setter @ToString @EqualsAndHashCode
public class Item {
	@Setter(value = AccessLevel.PROTECTED)
	private @NonNull Integer id;
	private @NonNull String displayName;
	private Coordinates coordinates;
}
