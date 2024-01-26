package com.sickgyun.server.coffeechat.presentation.dto;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.domain.User;

public record CoffeeChatRequest(
	String message
) {

	public CoffeeChat toEntity(User fromUser) {
		return new CoffeeChat(message, State.PENDING, fromUser);
	}
}
