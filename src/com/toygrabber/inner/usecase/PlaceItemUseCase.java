package com.toygrabber.inner.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.base.command.Command;
import com.toygrabber.base.exception.NoItemException;
import com.toygrabber.inner.domain.Item;

public class PlaceItemUseCase implements Command {	
	private Collection<Item> items; 
	
	public PlaceItemUseCase(Collection<Item> items) {
		this.items = new ArrayList<>(items);
	}
	
	public void execute() {
		try {
			execute(items);
		} catch (NoItemException e) {
			
		}
	}
	
	void execute(Collection<Item> items) throws NoItemException {
		throwExceptionIfNoItems(items);
		for (Item item : items) {
			PlaceItemCommand.beginCommand(item).execute();
		}
	}
	
	void throwExceptionIfNoItems(Collection<Item> items) throws NoItemException {
		if (items.size() <= 0) {
			throw new NoItemException();
		}
	}
}
