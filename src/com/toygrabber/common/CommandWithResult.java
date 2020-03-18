package com.toygrabber.common;

public interface CommandWithResult<TResult> {
	TResult execute();
}
