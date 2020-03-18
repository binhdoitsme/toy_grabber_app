package com.toygrabber.inner.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.base.requesthandler.Request;
import com.toygrabber.base.requesthandler.Response;
import com.toygrabber.inner.domain.Item;

public class GrabItemResponse implements Request, Response {
	private Collection<Item> grabbedItems;
	
	public GrabItemResponse() {
		this.grabbedItems = new ArrayList<Item>();
	}
	
	public GrabItemResponse(Collection<Item> grabbedItems) {
		this.grabbedItems = new ArrayList<>(grabbedItems);
	}
	
	public Collection<Item> getGrabbedItems() {
		return this.grabbedItems;
	}
}
