package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record ReceivedCoffeeChatResponse(
	Long id,
	State state,
	UserResponse toUser,
	UserResponse fromUser,
	String message
) {

	public static ReceivedCoffeeChatResponse from(CoffeeChat coffeeChat) {
		return new ReceivedCoffeeChatResponse(
			coffeeChat.getId(),
			coffeeChat.getState(),
			UserResponse.from(coffeeChat.getToUser()),
			UserResponse.from(coffeeChat.getFromUser()),
			coffeeChat.getState() == State.ACCEPT ? coffeeChat.getMessage() : null
		);
	}
}
