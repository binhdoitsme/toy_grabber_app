package com.toygrabber.datatransfer;

import com.toygrabber.common.DataTransfer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemListDto extends DataTransfer {
	private @NonNull String[] wonItems;
}
