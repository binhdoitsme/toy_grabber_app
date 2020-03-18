package com.toygrabber.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.toygrabber.common.DataTransfer;
import com.toygrabber.common.View;
import com.toygrabber.controller.ToyGrabberController;
import com.toygrabber.datatransfer.CoordinatesDto;
import com.toygrabber.datatransfer.InsertedCoinsDto;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.exception.NoMoreTurnException;
import com.toygrabber.usecase.LookupItemEvent;

public class ViewEngine implements View {
	
	private static final String TERMINATE_CHAR_SEQ = "X!";
	
	private ToyGrabberController controller;
	private boolean coinInserted = false;
	private int turnCount;
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
		String message = controller.getPrize(aimedPositions);
		showMessage(message);
		onTurnsExpired();
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
