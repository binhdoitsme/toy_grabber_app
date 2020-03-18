package com.toygrabber.test.usecase;

import static org.junit.Assert.assertNotEquals;

import java.util.Collection;

import org.junit.Test;

import com.toygrabber.common.DataTransfer;
import com.toygrabber.datatransfer.CoordinatesDto;
import com.toygrabber.datatransfer.InsertedCoinsDto;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;
import com.toygrabber.test.common.TestInitializer;
import com.toygrabber.usecase.GrabItemRequest;
import com.toygrabber.usecase.GrabItemUseCase;
import com.toygrabber.usecase.InsertCoinRequest;
import com.toygrabber.usecase.InsertCoinUseCase;
import com.toygrabber.usecase.LookupItemEvent;
import com.toygrabber.usecase.PlaceClawRequest;
import com.toygrabber.usecase.PlaceClawUseCase;
import com.toygrabber.usecase.PlaceItemUseCase;

public class UseCaseTest {
	@Test
	public void testInsertCoinUseCase() {
		InsertCoinRequest request = new InsertCoinRequest(new InsertedCoinsDto(2));
		new InsertCoinUseCase().handle(request);
	}

	@Test
	public void testPlaceClawUseCase() {
		Collection<Integer[]> requestCoordinatesArray = TestInitializer.initializeTestCoordinatesDto();
		DataTransfer requestCoordinates = new CoordinatesDto(requestCoordinatesArray);
		PlaceClawRequest request = new PlaceClawRequest(requestCoordinates);
		new PlaceClawUseCase().handle(request);
	}
	
	@Test
	public void testGrabItemUseCase() {
		Collection<Coordinates> requestCoordinates = TestInitializer.initializeTestCoordinates();
		LookupItemEvent event = new MockEvent();
		GrabItemRequest request = new GrabItemRequest(requestCoordinates, event);
		new GrabItemUseCase().handle(request);
	}
	
	@Test
	public void testPlaceItems() {
		Collection<Item> items = TestInitializer.initializeTestItems();
		new PlaceItemUseCase(items).execute();
		noItemIsNotPlacedIn(items);
	}
	
	void noItemIsNotPlacedIn(Collection<Item> items) {
		for (Item item : items) {
			assertNotEquals(null, item.getCoordinates());
		}
	}
}
