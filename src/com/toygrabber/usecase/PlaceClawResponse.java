package com.toygrabber.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.DataTransfer;
import com.toygrabber.common.Response;
import com.toygrabber.datatransfer.CoordinatesDto;
import com.toygrabber.domain.Coordinates;

public class PlaceClawResponse implements Response {
	private Collection<Coordinates> aimedPositions;

	public PlaceClawResponse(DataTransfer coordinatesDto) {
		this.aimedPositions = new ArrayList<>();
		aimedPositions.addAll(createPositions((CoordinatesDto) coordinatesDto));
	}

	Collection<Coordinates> createPositions(CoordinatesDto coordinatesDto) {
		Collection<Coordinates> coordinates = new ArrayList<>();
		for (Integer[] coordinatePair : coordinatesDto.getInputCoordinates()) {
			coordinates.add(createPositionFrom(coordinatePair));
		}
		return coordinates;
	}
	
	Coordinates createPositionFrom(Integer[] coordinatePair) {
		int x = coordinatePair[0];
		int y = coordinatePair[1];
		return Coordinates.from(x, y);
	}

	public Collection<Coordinates> getAimedPositions() {
		return aimedPositions;
	}
}
