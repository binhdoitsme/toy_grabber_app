package com.toygrabber.driver.event;

import java.util.Collection;

import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.repository.ItemRepository;
import com.toygrabber.inner.usecase.event.LookupItemEvent;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class LookupItemEventImpl implements LookupItemEvent {
	
	private @NonNull ItemRepository repository;
	
	private @Setter Collection<Coordinates> positions;

	@Override
	public Collection<Item> getResult() {
		return repository.findByPositions(positions);
	}
	
}
