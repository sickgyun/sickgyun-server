package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record ReceivedCoffeeChatResponse(
	Long id,
	State state,
	UserResponse toUser,
	UserResponse fromUser,
	String sendMessage,
	String rejectMessage,
	ContactResponse contact
) {

	public static ReceivedCoffeeChatResponse from(CoffeeChat coffeeChat) {
		return new ReceivedCoffeeChatResponse(
			coffeeChat.getId(),
			coffeeChat.getState(),
			UserResponse.from(coffeeChat.getToUser()),
			UserResponse.from(coffeeChat.getFromUser()),
			coffeeChat.getSendMessage(),
			coffeeChat.getRejectMessage(),
			coffeeChat.getState() == State.ACCEPT ? ContactResponse.from(coffeeChat.getFromUser().getContact()) : null
		);
	}
}
