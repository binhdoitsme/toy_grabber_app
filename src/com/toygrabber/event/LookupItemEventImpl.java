package com.toygrabber.event;

import java.util.Collection;

import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;
import com.toygrabber.repository.ItemRepository;
import com.toygrabber.usecase.LookupItemEvent;

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
