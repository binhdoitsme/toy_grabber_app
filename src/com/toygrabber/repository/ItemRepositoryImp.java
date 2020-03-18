package com.toygrabber.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;

public class ItemRepositoryImp implements ItemRepository {
	protected Map<Integer, Item> availableItems = new HashMap<Integer, Item>()
	{
		private static final long serialVersionUID = -6326194627541510505L;

		{
			put(1, new Item(1, "Bob Minion"));
			put(2, new Item(2, "Cutie Little Banana"));
			put(3, new Item(3, "Mr Bean's Teddy Bear"));
			put(4, new Item(4, "Little Pink Panther"));
			put(5, new Item(5, "Mickey Mouse Limited Edition"));
			put(6, new Item(6, "Doraemon Limited Edition"));
		}
	};

	@Override
	public <S extends Item> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findOne(Integer primaryKey) {
		return availableItems.get(primaryKey);
	}

	@Override
	public Collection<Item> findAll() {
		return availableItems.values();
	}

	@Override
	public Long count() {
		return (long)availableItems.size();
	}

	@Override
	public void delete(Item entity) {
		availableItems.remove(entity.getId(), entity);
	}

	@Override
	public boolean exists(Integer primaryKey) {
		return availableItems.containsKey(primaryKey);
	}

	@Override
	public Collection<Item> findByPosition(Coordinates position) {
		List<Item> matchedItems = new ArrayList<Item>();
		this.availableItems.forEach((id, item) -> {
			if (item.getCoordinates().equals(position)) {
				matchedItems.add(item);
			}
		});
		return matchedItems;
	}
	
	@Override
	public Collection<Item> findByPositions(Collection<Coordinates> positions) {
		List<Item> matchedItems = new ArrayList<Item>();
		for (Coordinates position : positions) {
			matchedItems.addAll(findByPosition(position));
		}
		return matchedItems;
	}

}
