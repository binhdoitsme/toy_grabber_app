package com.toygrabber.middle.controller;

import java.util.Collection;

import com.toygrabber.base.datatransfer.DataTransfer;
import com.toygrabber.base.presenter.ResponsePresenter;
import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.base.requesthandler.Response;
import com.toygrabber.inner.domain.Coordinates;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.usecase.GrabItemRequest;
import com.toygrabber.inner.usecase.GrabItemResponse;
import com.toygrabber.inner.usecase.GrabItemUseCase;
import com.toygrabber.inner.usecase.InsertCoinRequest;
import com.toygrabber.inner.usecase.InsertCoinResponse;
import com.toygrabber.inner.usecase.InsertCoinUseCase;
import com.toygrabber.inner.usecase.PlaceClawRequest;
import com.toygrabber.inner.usecase.PlaceClawResponse;
import com.toygrabber.inner.usecase.PlaceClawUseCase;
import com.toygrabber.inner.usecase.event.LookupItemEvent;
import com.toygrabber.middle.presenter.ToyGrabberPresenter;

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
		GrabItemResponse response = (GrabItemResponse)new GrabItemUseCase().handle(grabItemRequest);
		return getPrizeMessage(response);
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
