package com.toygrabber.driver;

import java.util.Collection;
import java.util.function.Consumer;

import com.toygrabber.base.exception.NoMoreTurnException;
import com.toygrabber.driver.event.LookupItemEventImpl;
import com.toygrabber.driver.repository.ItemRepositoryImp;
import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.repository.ItemRepository;
import com.toygrabber.inner.usecase.PlaceItemUseCase;
import com.toygrabber.inner.usecase.event.LookupItemEvent;
import com.toygrabber.outer.view.ViewEngine;

public class ToyGrabberMain implements Runnable {
	private ItemRepository repository;
	private LookupItemEvent event;
	private ViewEngine viewEngine;
	private Consumer<Collection<Coordinates>> eventHandler;

	public void run() {
		setupPersistence();
		setupItems();
		setupEvent();
		setupView();
		runMainLoop();
	}

	void setupView() {
		eventHandler = this::setEventPosition;
		viewEngine = new ViewEngine();
		viewEngine.setEvent(event);
		viewEngine.setBroadcastLookupItemEventWith(eventHandler);
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
	
	void setEventPosition(Collection<Coordinates> positions) {
		((LookupItemEventImpl)event).setPositions(positions);
	}

	public static void main(String[] args) {
		new ToyGrabberMain().run();
	}
}
