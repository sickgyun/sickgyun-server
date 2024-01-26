package com.sickgyun.server.coffeeChat.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;
import com.sickgyun.server.coffeeChat.domain.value.State;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatUpdater {

	public void updateState(CoffeeChat coffeeChat, State state) {
		coffeeChat.updateState(state);
	}
}
