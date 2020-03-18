package com.toygrabber.inner.usecase;

import com.toygrabber.base.datatransfer.DataTransfer;
import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.inner.datatransfer.CoordinatesDto;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class PlaceClawRequest implements Request {
	private @NonNull CoordinatesDto requestCoordinates;
	
	public PlaceClawRequest(DataTransfer requestCoordinates) {
		this.requestCoordinates = (CoordinatesDto) requestCoordinates;
	}
}
