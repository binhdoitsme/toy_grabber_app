package com.toygrabber.datatransfer;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.DataTransfer;

import lombok.Getter;

@Getter
public class CoordinatesDto extends DataTransfer {
	private Collection<Integer[]> inputCoordinates;
	
	public CoordinatesDto(Collection<Integer[]> inputCoordinates) {
		this.inputCoordinates = new ArrayList<>(inputCoordinates);
	}
}
