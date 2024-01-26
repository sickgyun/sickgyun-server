package com.sickgyun.server.coffeeChat.service;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;
import com.sickgyun.server.coffeeChat.service.implementation.CoffeeChatCreator;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.implementation.UserReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandCoffeeChatService {

	private final CoffeeChatCreator coffeeChatCreator;
	private final UserReader userReader;

	public void create(CoffeeChat coffeeChat, Long toUserId) {
		User toUser = userReader.readUser(toUserId);
		coffeeChat.updateToUser(toUser);
		coffeeChatCreator.create(coffeeChat);
	}
}
