package com.toygrabber.middle.presenter;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.base.presenter.ResponsePresenter;
import com.toygrabber.base.requesthandler.Response;
import com.toygrabber.inner.domain.Item;
import com.toygrabber.inner.usecase.GrabItemResponse;

public class ToyGrabberPresenter implements ResponsePresenter<Response, String> {
	@Override
	public String handle(Response input) {
		Collection<Item> grabbedItems = ((GrabItemResponse)input).getGrabbedItems();
		String[] presentedItems = toPresentedItems(grabbedItems);
		return toPresentedString(presentedItems);
	}
	
	String[] toPresentedItems(Collection<Item> grabbedItems) {
		Collection<String> presentedItems = new ArrayList<>();
		int numOfGrabbedItems = presentedItems.size();
		for (Item item : grabbedItems) {
			presentedItems.add(item.toString());
		}
		return presentedItems.toArray(new String[numOfGrabbedItems]);
	}
	
	String toPresentedString(String[] presentedItems) {
		StringBuilder sb = new StringBuilder();
		for (String item : presentedItems) {
			sb.append(item).append("\n");
		}
		return sb.toString().trim();
	}
}
