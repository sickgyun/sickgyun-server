package com.sickgyun.server.coffeechat.service;

import static com.sickgyun.server.coffeechat.domain.value.State.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatCreator;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatDeleter;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatReader;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatUpdater;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatValidator;
import com.sickgyun.server.mail.MailService;
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
	private final CoffeeChatDeleter coffeeChatDeleter;
	private final UserReader userReader;
	private final MailService mailService;

	public void create(CoffeeChat coffeeChat, Long toUserId) {
		User toUser = userReader.readUser(toUserId);
		coffeeChatValidator.shouldNotExistSameCoffeeChatPending(coffeeChat, toUser);
		coffeeChat.updateToUser(toUser);
		coffeeChatCreator.create(coffeeChat);
		mailService.sendMail(coffeeChat);
	}

	public CoffeeChat accept(User user, Long coffeeChatId) {
		CoffeeChat coffeeChat = coffeeChatReader.read(coffeeChatId);
		coffeeChatValidator.shouldBeSameUser(user, coffeeChat.getToUser());
		coffeeChatValidator.shouldBePending(coffeeChat);
		coffeeChatUpdater.updateState(coffeeChat, ACCEPT);
		mailService.sendMail(coffeeChat);
		return coffeeChat;
	}

	public void reject(User user, Long coffeeChatId, String message) {
		CoffeeChat coffeeChat = coffeeChatReader.read(coffeeChatId);
		coffeeChatValidator.shouldBeSameUser(user, coffeeChat.getToUser());
		coffeeChatValidator.shouldBePending(coffeeChat);
		coffeeChatUpdater.updateState(coffeeChat, REJECT, message);
		mailService.sendMail(coffeeChat);
	}

	public void deleteCoffeeChat(User currentUser, Long coffeeChatId) {
		CoffeeChat coffeeChat = coffeeChatReader.read(coffeeChatId);
		coffeeChatValidator.shouldBeSameUser(currentUser, coffeeChat.getFromUser());
		coffeeChatValidator.shouldBePending(coffeeChat);
		coffeeChatDeleter.delete(coffeeChat);
	}
}
