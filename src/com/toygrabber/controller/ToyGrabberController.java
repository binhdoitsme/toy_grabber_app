package com.toygrabber.controller;

import java.util.Collection;

import com.toygrabber.common.DataTransfer;
import com.toygrabber.common.Request;
import com.toygrabber.common.Response;
import com.toygrabber.common.ResponsePresenter;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;
import com.toygrabber.event.LookupItemEventImpl;
import com.toygrabber.presenter.ToyGrabberPresenter;
import com.toygrabber.usecase.GrabItemRequest;
import com.toygrabber.usecase.GrabItemResponse;
import com.toygrabber.usecase.GrabItemUseCase;
import com.toygrabber.usecase.InsertCoinRequest;
import com.toygrabber.usecase.InsertCoinResponse;
import com.toygrabber.usecase.InsertCoinUseCase;
import com.toygrabber.usecase.LookupItemEvent;
import com.toygrabber.usecase.PlaceClawRequest;
import com.toygrabber.usecase.PlaceClawResponse;
import com.toygrabber.usecase.PlaceClawUseCase;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ToyGrabberController {
	@Setter
	private LookupItemEvent event;
	
	public int insertCoins(DataTransfer insertedCoins) {
		Request coinInsertRequest = new InsertCoinRequest(insertedCoins);
		InsertCoinResponse response = (InsertCoinResponse)new InsertCoinUseCase().handle(coinInsertRequest);
		int numOfTurns = response.getNumOfTurns();
		return numOfTurns;
	}
	
	public Collection<Coordinates> getAimedPositions(DataTransfer coordinatesDto) {
		Request clawAimRequest = new PlaceClawRequest(coordinatesDto);
		PlaceClawResponse response = (PlaceClawResponse)new PlaceClawUseCase().handle(clawAimRequest);
		return response.getAimedPositions();
	}
	
	public String getPrize(Collection<Coordinates> positions) {
		GrabItemRequest grabItemRequest = new GrabItemRequest(positions, event);
		setEventPosition(positions, event);
		GrabItemResponse response = (GrabItemResponse)new GrabItemUseCase().handle(grabItemRequest);
		return getPrizeMessage(response);
	}
	
	void setEventPosition(Collection<Coordinates> positions, LookupItemEvent event) {
		((LookupItemEventImpl)event).setPositions(positions);
	}
	
	public String getPrizeMessage(GrabItemResponse response) {
		Collection<Item> grabbedItems = response.getGrabbedItems();
		if (grabbedItems.size() > 0) {
			return congratulations(response);
		} else {
			return goodLuckNextTime();
		}
	}
	
	private String goodLuckNextTime() {
		return "Good luck next time!";
	}
	
	private String congratulations(Response response) {
		StringBuilder sb = new StringBuilder();
		sb.append("Congratulations, you have won the following items: \n");
		ResponsePresenter<Response, String> presenter = new ToyGrabberPresenter();
		String presentedItemsAsString = presenter.handle(response);
		sb.append(presentedItemsAsString);
		return sb.toString().trim();
	}
}
