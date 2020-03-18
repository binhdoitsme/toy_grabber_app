package com.toygrabber.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.Request;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.repository.ItemRepository;

import lombok.Getter;

@Getter
public class GrabItemRequest implements Request {
	private Collection<Coordinates> coordinates;
	private ItemRepository repository;

	public GrabItemRequest(Collection<Coordinates> input, ItemRepository repository) {
		this.repository = repository;
		this.coordinates = new ArrayList<>(input);
	}
}
