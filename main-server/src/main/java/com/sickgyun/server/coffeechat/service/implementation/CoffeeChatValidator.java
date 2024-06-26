package com.sickgyun.server.coffeechat.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.repository.CoffeeChatRepository;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.coffeechat.exception.HasSameCoffeeChatPendingException;
import com.sickgyun.server.coffeechat.exception.NotAlreadyPendingException;
import com.sickgyun.server.coffeechat.exception.NotMatchFromUserException;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatValidator {
	private final CoffeeChatRepository coffeeChatRepository;

	public void shouldBeSameUser(User user, User toUser) {
		if (!toUser.getId().equals(user.getId())) {
			throw new NotMatchFromUserException(user);
		}
	}

	public void shouldBePending(CoffeeChat coffeeChat) {
		if (!coffeeChat.getState().equals(State.PENDING)) {
			throw new NotAlreadyPendingException(coffeeChat);
		}
	}

	public void shouldNotExistSameCoffeeChatPending(CoffeeChat coffeeChat, User toUser) {
		Boolean exist = coffeeChatRepository.existsByToUserAndFromUserAndState(
			toUser,
			coffeeChat.getFromUser(),
			coffeeChat.getState()
		);

		if (exist) {
			throw new HasSameCoffeeChatPendingException(toUser.getName());
		}
	}
}
