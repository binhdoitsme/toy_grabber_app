package com.toygrabber.test.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;

public class TestInitializer {
	public static Collection<Integer[]> initializeTestCoordinatesDto() {
		Collection<Integer[]> requestCoordinatesArray = new ArrayList<Integer[]>() 
		{
			private static final long serialVersionUID = -3620155937432506326L;

			{
				add(new Integer[] { 2, 5 });
				add(new Integer[] { 5, 1 });
			}
		};
		return requestCoordinatesArray;
	}
	
	public static Collection<Coordinates> initializeTestCoordinates() {
		Collection<Coordinates> requestCoordinates = new ArrayList<Coordinates>()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 7739229793687266456L;

			{
				add(Coordinates.from(1, 1));
				add(Coordinates.from(5, 2));
			}
		};
		return requestCoordinates;
	}
	
	public static Collection<Item> initializeTestItems() {
		Item itOne = new Item(1, "Name ONE");
		itOne.setCoordinates(Coordinates.from(1, 2));
		List<Item> items = new ArrayList<Item>();
		items.add(itOne);
		return items;
	}
	
}
