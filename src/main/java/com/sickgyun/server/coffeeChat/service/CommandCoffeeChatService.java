package com.sickgyun.server.coffeeChat.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;
import com.sickgyun.server.coffeeChat.domain.value.State;
import com.sickgyun.server.coffeeChat.service.implementation.CoffeeChatCreator;
import com.sickgyun.server.coffeeChat.service.implementation.CoffeeChatReader;
import com.sickgyun.server.coffeeChat.service.implementation.CoffeeChatUpdater;
import com.sickgyun.server.coffeeChat.service.implementation.CoffeeChatValidator;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.implementation.UserReader;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandCoffeeChatService {

	private final CoffeeChatCreator coffeeChatCreator;
	private final CoffeeChatReader coffeeChatReader;
	private final CoffeeChatValidator coffeeChatValidator;
	private final CoffeeChatUpdater coffeeChatUpdater;
	private final UserReader userReader;

	public void create(CoffeeChat coffeeChat, Long toUserId) {
		User toUser = userReader.readUser(toUserId);
		coffeeChat.updateToUser(toUser);
		coffeeChatCreator.create(coffeeChat);
	}

	public void accept(User user, Long coffeeChatId) {
		CoffeeChat coffeeChat = coffeeChatReader.read(coffeeChatId);
		coffeeChatValidator.shouldBeSameUser(user, coffeeChat.getToUser());
		coffeeChatValidator.shouldAlreadyBeAccepted(coffeeChat);
		coffeeChatUpdater.updateState(coffeeChat, State.ACCEPT);
	}
}
