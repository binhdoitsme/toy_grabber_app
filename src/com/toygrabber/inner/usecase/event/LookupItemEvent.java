package com.toygrabber.inner.usecase.event;

import java.util.Collection;

import com.toygrabber.base.event.EventWithResult;
import com.toygrabber.inner.domain.Item;

public interface LookupItemEvent extends EventWithResult<Collection<Item>> {
	
}
