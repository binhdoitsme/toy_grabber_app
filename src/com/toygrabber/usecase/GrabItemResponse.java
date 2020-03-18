package com.toygrabber.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.Request;
import com.toygrabber.common.Response;
import com.toygrabber.domain.Item;

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
