package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.presentation.dto.UserResponse;

public record MySentCoffeeChatResponse(
	Long id,
	State state,
	String sendMessage,
	String rejectMessage,
	ContactResponse contact,
	UserResponse toUser,
	UserResponse fromUser
) {

	public static MySentCoffeeChatResponse from(CoffeeChat coffeeChat) {
		return new MySentCoffeeChatResponse(
			coffeeChat.getId(),
			coffeeChat.getState(),
			coffeeChat.getSendMessage(),
			coffeeChat.getRejectMessage(),
			coffeeChat.getState().equals(State.ACCEPT)
				? ContactResponse.from(coffeeChat.getToUser().getContact()) : null,
			UserResponse.from(coffeeChat.getToUser()),
			UserResponse.from(coffeeChat.getFromUser())
		);
	}
}
