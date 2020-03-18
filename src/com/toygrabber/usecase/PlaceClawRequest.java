package com.toygrabber.usecase;

import com.toygrabber.common.DataTransfer;
import com.toygrabber.common.Request;
import com.toygrabber.datatransfer.CoordinatesDto;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class PlaceClawRequest implements Request {
	private @NonNull CoordinatesDto requestCoordinates;
	
	public PlaceClawRequest(DataTransfer requestCoordinates) {
		this.requestCoordinates = (CoordinatesDto) requestCoordinates;
	}
}
