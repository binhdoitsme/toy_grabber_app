package com.toygrabber.base.presenter;

import com.toygrabber.base.requesthandler.Response;

public interface ResponsePresenter<TInput extends Response, TOutput> {
	TOutput handle(TInput input); 
}
