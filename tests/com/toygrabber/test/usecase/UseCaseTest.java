package com.toygrabber.test.usecase;

import static org.junit.Assert.assertNotEquals;

import java.util.Collection;

import org.junit.Test;

import com.toygrabber.base.datatransfer.DataTransfer;
import com.toygrabber.inner.datatransfer.CoordinatesDto;
import com.toygrabber.inner.datatransfer.InsertedCoinsDto;
import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.usecase.GrabItemRequest;
import com.toygrabber.inner.usecase.GrabItemUseCase;
import com.toygrabber.inner.usecase.InsertCoinRequest;
import com.toygrabber.inner.usecase.InsertCoinUseCase;
import com.toygrabber.inner.usecase.PlaceClawRequest;
import com.toygrabber.inner.usecase.PlaceClawUseCase;
import com.toygrabber.inner.usecase.PlaceItemUseCase;
import com.toygrabber.inner.usecase.event.LookupItemEvent;
import com.toygrabber.test.common.TestInitializer;

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
