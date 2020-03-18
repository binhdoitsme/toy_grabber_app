package com.toygrabber.usecase;

import java.util.Collection;

import com.toygrabber.common.EventWithResult;
import com.toygrabber.domain.Item;

public interface LookupItemEvent extends EventWithResult<Collection<Item>> {
	
}
