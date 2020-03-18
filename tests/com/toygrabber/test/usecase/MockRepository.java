package com.toygrabber.test.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.repository.ItemRepository;

public class MockRepository implements ItemRepository {
	
	private Collection<Item> generateMockCollection() {
		ArrayList<Item> allItems = new ArrayList<Item>();
		allItems.add(new Item(1, "An item"));
		return allItems;
	}
	
	@Override
	public <S extends Item> S save(S entity) {
		return null;
	}
	@Override
	public Item findOne(Integer primaryKey) {
		return new Item(1, "An item");
	}
	@Override
	public Collection<Item> findAll() {
		return generateMockCollection();
	}
	@Override
	public Long count() {
		return 1l;
	}
	@Override
	public void delete(Item entity) {
		
	}
	@Override
	public boolean exists(Integer primaryKey) {
		return false;
	}
	
	@Override
	public Collection<Item> findByPosition(Coordinates position) {
		return null;
	}
	
	@Override
	public Collection<Item> findByPositions(Collection<Coordinates> positions) {
		return generateMockCollection();
	}
}
