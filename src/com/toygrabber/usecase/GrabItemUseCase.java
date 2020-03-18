package com.toygrabber.usecase;

import java.util.ArrayList;
import java.util.Collection;

import com.toygrabber.common.Request;
import com.toygrabber.common.RequestHandler;
import com.toygrabber.common.Response;
import com.toygrabber.domain.Coordinates;
import com.toygrabber.domain.Item;
import com.toygrabber.repository.ItemRepository;

public class GrabItemUseCase implements RequestHandler<Request, Response> {
	
	@Override
	public <T extends Request> Response handle(T input) {
		return handle((GrabItemRequest) input);
	}
	
	public Response handle(GrabItemRequest input) {
		Collection<Item> result = new ArrayList<Item>();
		ItemRepository repository = input.getRepository();
		for (Coordinates coordinates : input.getCoordinates()) {
			result.addAll(repository.findByPosition(coordinates));
		}
		return new GrabItemResponse(result);
	}

}
