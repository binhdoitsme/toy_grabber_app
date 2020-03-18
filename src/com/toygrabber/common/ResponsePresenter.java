package com.toygrabber.common;

public interface ResponsePresenter<TInput extends Response, TOutput> {
	TOutput handle(TInput input); 
}
