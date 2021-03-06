package com.toygrabber.base.requesthandler;

public interface RequestHandler<TInput extends Request, TOutput extends Response> {
	<T extends TInput> TOutput handle(T request);
}
