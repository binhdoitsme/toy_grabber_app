package com.toygrabber.inner.datatransfer;

import com.toygrabber.base.datatransfer.DataTransfer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemListDto extends DataTransfer {
	private @NonNull String[] wonItems;
}
