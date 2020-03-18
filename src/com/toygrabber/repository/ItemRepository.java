package com.toygrabber.repository;

import java.util.Collection;

import com.toygrabber.common.Repository;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;

public interface ItemRepository extends Repository<Item, Integer> {
	Collection<Item> findByPosition(Coordinates position);
	Collection<Item> findByPositions(Collection<Coordinates> positions); 
}
