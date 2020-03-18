package com.toygrabber.test.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.usecase.event.LookupItemEvent;

public class MockEvent implements LookupItemEvent {
	
	Collection<Coordinates> positions = null;

	@Override
	public Collection<Item> getResult() {
		Item item = new Item(1, "aaa");
		Collection<Item> items = new ArrayList<Item>();
		items.add(item);
		return items;
	}
	
}
