package com.toygrabber.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.Request;
import com.toygrabber.domain.Coordinates;
import lombok.Getter;

@Getter
public class GrabItemRequest implements Request {
	private Collection<Coordinates> coordinates;
	private LookupItemEvent event;

	public GrabItemRequest(Collection<Coordinates> input, LookupItemEvent event) {
		this.event = event;
		this.coordinates = new ArrayList<>(input);
	}
}
