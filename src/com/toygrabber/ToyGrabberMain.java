package com.toygrabber;

import java.util.Collection;

import com.toygrabber.domain.Item;
import com.toygrabber.exception.NoMoreTurnException;
import com.toygrabber.repository.ItemRepository;
import com.toygrabber.repository.ItemRepositoryImp;
import com.toygrabber.usecase.PlaceItemUseCase;
import com.toygrabber.view.ViewEngine;

public class ToyGrabberMain implements Runnable {
	private ItemRepository repository;
	private ViewEngine viewEngine;

	public void run() {
		setupPersistence();
		setupItems();
		setupView();
		runMainLoop();
	}

	void setupView() {
		viewEngine = new ViewEngine();
		viewEngine.setRepository(repository);
	}

	void setupItems() {
		Collection<Item> items = repository.findAll();
		new PlaceItemUseCase(items).execute();
	}

	void setupPersistence() {
		repository = new ItemRepositoryImp();
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
