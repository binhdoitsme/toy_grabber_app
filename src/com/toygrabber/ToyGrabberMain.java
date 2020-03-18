package com.toygrabber;

import java.util.Collection;

import com.toygrabber.domain.Item;
import com.toygrabber.event.LookupItemEventImpl;
import com.toygrabber.exception.NoMoreTurnException;
import com.toygrabber.repository.ItemRepository;
import com.toygrabber.repository.ItemRepositoryImp;
import com.toygrabber.usecase.LookupItemEvent;
import com.toygrabber.usecase.PlaceItemUseCase;
import com.toygrabber.view.ViewEngine;

public class ToyGrabberMain implements Runnable {
	private ItemRepository repository;
	private LookupItemEvent event;
	private ViewEngine viewEngine;

	public void run() {
		setupPersistence();
		setupItems();
		setupEvent();
		setupView();
		runMainLoop();
	}

	void setupView() {
		viewEngine = new ViewEngine();
		viewEngine.setEvent(event);
	}

	void setupItems() {
		Collection<Item> items = repository.findAll();
		new PlaceItemUseCase(items).execute();
	}

	void setupPersistence() {
		repository = new ItemRepositoryImp();
	}
	
	void setupEvent() {
		event = new LookupItemEventImpl(repository);
	}
	
	void runMainLoop() {
		while (true) {
			try {
				viewEngine.welcome();
			} catch (NoMoreTurnException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ToyGrabberMain().run();
	}
}
