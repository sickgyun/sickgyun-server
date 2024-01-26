package com.sickgyun.server.coffeeChat.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;
import com.sickgyun.server.coffeeChat.domain.value.State;
import com.sickgyun.server.coffeeChat.exception.AlreadyAcceptedException;
import com.sickgyun.server.coffeeChat.exception.NotMatchFromUserException;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatValidator {

	public void shouldBeSameUser(User user, User toUser) {
		if (!toUser.getId().equals(user.getId())) {
			throw new NotMatchFromUserException(user);
		}
	}

	public void shouldAlreadyBeAccepted(CoffeeChat coffeeChat) {
		if (!coffeeChat.getState().equals(State.ACCEPT)) {
			throw new AlreadyAcceptedException(coffeeChat);
		}
	}
}
