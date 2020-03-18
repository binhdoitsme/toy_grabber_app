package com.toygrabber.base.command;

public interface CommandWithResult<TResult> {
	TResult execute();
}
