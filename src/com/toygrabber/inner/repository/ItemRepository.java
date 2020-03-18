package com.toygrabber.inner.repository;

import java.util.Collection;

import com.toygrabber.base.repository.Repository;
import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;

public interface ItemRepository extends Repository<Item, Integer> {
	Collection<Item> findByPosition(Coordinates position);
	Collection<Item> findByPositions(Collection<Coordinates> positions); 
}
