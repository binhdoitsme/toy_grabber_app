package com.toygrabber.outer.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Consumer;

import com.toygrabber.base.datatransfer.DataTransfer;
import com.toygrabber.base.exception.NoMoreTurnException;
import com.toygrabber.base.view.View;
import com.toygrabber.inner.datatransfer.CoordinatesDto;
import com.toygrabber.inner.datatransfer.InsertedCoinsDto;
import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.usecase.event.LookupItemEvent;
import com.toygrabber.middle.controller.ToyGrabberController;

import lombok.Setter;

public class ViewEngine implements View {
	
	private static final String TERMINATE_CHAR_SEQ = "X!";
	
	private ToyGrabberController controller;
	private boolean coinInserted = false;
	private int turnCount;
	@Setter
	private Consumer<Collection<Coordinates>> broadcastLookupItemEventWith;
	Scanner scanner;
	
	public ViewEngine() {
		controller = new ToyGrabberController();
		scanner = new Scanner(System.in);
		turnCount = 0;
	}
	
	public void setEvent(LookupItemEvent event) {
		controller.setEvent(event);
	}
	
	public void welcome() throws NoMoreTurnException {
		showMessage("Welcome, insert coins to continue!");
		showMessage("You can quit any time by entering \"X!\"");
		insertCoin();
		dropClaw();
	}
	
	void insertCoin() {
		int insertedCoinCnt = getInputIntForMessage("How many coins? ");
		DataTransfer insertedCoinsDto = new InsertedCoinsDto(insertedCoinCnt);
		int turnCnt = controller.insertCoins(insertedCoinsDto);
		addTurns(turnCnt);
		onCoinInserted();
	}
	
	void dropClaw() throws NoMoreTurnException {
		throwExceptionOnTurnsExpire();
		DataTransfer coordinatesDto = fillCoordinates();
		Collection<Coordinates> aimedPositions = controller.getAimedPositions(coordinatesDto);
		onUserHasAimedDo(broadcastLookupItemEventWith, aimedPositions);
		String message = controller.getPrize(aimedPositions);
		showMessage(message);
		onTurnsExpired();
	}
	
	<T> void onUserHasAimedDo(Consumer<T> callback, T arg) {
		callback.accept(arg);
	}
	
	void showMessage(String message) {
		System.out.println(message);
	}
	
	int getInputIntForMessage(String message) {
		System.out.print(message);
		String inputLine = scanner.nextLine();
		onInputExit(inputLine);
		return Integer.parseInt(inputLine);
	}
	
	void onInputExit(String inputLine) {
		if (inputLine.equals(TERMINATE_CHAR_SEQ)) {
			System.exit(0);
		}
	}
	
	Integer[] fillCoordinatePair() {
		showMessage("Please aim for your item.");
		Integer[] coordinatePair = new Integer[2];
		coordinatePair[0] = getInputIntForMessage("Enter value for x: ");
		coordinatePair[1] = getInputIntForMessage("Enter value for y: ");
		return coordinatePair;
	}
	
	DataTransfer fillCoordinates() {
		Collection<Integer[]> coordinates = new ArrayList<>();
		for (int i = 0; i < turnCount; i++) {
			coordinates.add(fillCoordinatePair());
		}
		return new CoordinatesDto(coordinates);
	}
	
	void addTurns(int turnCnt) {
		this.turnCount += turnCnt;
	}
	
	void onCoinInserted() {
		if (turnCount != 0) {
			this.coinInserted = true;
		}
	}
	
	void onTurnsExpired() {
		this.coinInserted = false;
		this.turnCount = 0;
	}
	
	void throwExceptionOnTurnsExpire() throws NoMoreTurnException {
		if (!coinInserted) {
			throw new NoMoreTurnException();
		}
	}
}
