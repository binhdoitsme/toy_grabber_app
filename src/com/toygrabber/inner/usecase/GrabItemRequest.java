package com.toygrabber.inner.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.usecase.event.LookupItemEvent;

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
