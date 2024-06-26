package com.sickgyun.server.coffeechat.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatUpdater {

	public void reject(CoffeeChat coffeeChat, State state, String message) {
		coffeeChat.reject(state, message);
	}

	public void updateState(CoffeeChat coffeeChat, State state) {
		coffeeChat.updateState(state);
	}
}
