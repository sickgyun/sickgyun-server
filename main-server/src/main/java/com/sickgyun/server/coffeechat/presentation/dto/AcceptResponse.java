package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;

public record AcceptResponse(
	ContactResponse contact,
	String message

) {
	public static AcceptResponse from(CoffeeChat accept) {
		return new AcceptResponse(
			ContactResponse.from(accept.getFromUser().getContact()),
			accept.getSendMessage()
		);
	}
}
