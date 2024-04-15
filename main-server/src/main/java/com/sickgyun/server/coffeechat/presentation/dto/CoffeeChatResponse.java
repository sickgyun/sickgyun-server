package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record CoffeeChatResponse(
	Long id,
	State state,
	UserResponse toUser,
	UserResponse fromUser
) {

	public static CoffeeChatResponse from(CoffeeChat coffeeChat) {
		return new CoffeeChatResponse(
			coffeeChat.getId(),
			coffeeChat.getState(),
			UserResponse.from(coffeeChat.getToUser()),
			UserResponse.from(coffeeChat.getFromUser())
		);
	}
}
