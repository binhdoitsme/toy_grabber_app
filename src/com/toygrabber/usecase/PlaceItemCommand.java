package com.toygrabber.usecase;

import java.util.Random;

import com.toygrabber.common.Command;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;

public class PlaceItemCommand implements Command {
	
	private static final int UPPER_BOUND = 2;
	private static final int LOWER_BOUND = -2;
	
	private Item item;
	
	private PlaceItemCommand(Item item) {
		this.item = item;
	}
	
	public static Command beginCommand(Item item) {
		return new PlaceItemCommand(item);
	}
	
	private int generateRandomBetween(int lowerBound, int upperBound) {
		Random generator = new Random();
		return generator.nextInt(upperBound) + lowerBound;
	}
	
	private Coordinates generateCoordinatesBetween(int lowerBound, int upperBound) {
		int x = generateRandomBetween(lowerBound, upperBound);
		int y = generateRandomBetween(lowerBound, upperBound);
		return Coordinates.from(x, y);
	}
	
	public void execute() {
		Coordinates coordinates = generateCoordinatesBetween(LOWER_BOUND, UPPER_BOUND);
		item.setCoordinates(coordinates);
	}
}
