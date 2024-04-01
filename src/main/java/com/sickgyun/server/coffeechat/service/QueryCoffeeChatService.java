package com.sickgyun.server.coffeechat.service;

import static com.sickgyun.server.coffeechat.domain.value.State.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCoffeeChatService {

	private final CoffeeChatReader coffeeChatReader;

	public List<CoffeeChat> getByToUser(User user) {
		List<CoffeeChat> coffeeChats = coffeeChatReader.readByToUser(user, List.of(PENDING));
		coffeeChats.addAll(coffeeChatReader.readByToUser(user, List.of(ACCEPT, REJECT)));

		return coffeeChats;
	}

	public List<CoffeeChat> getByFromUser(User user) {
		List<CoffeeChat> coffeeChats = coffeeChatReader.readByFromUser(user, List.of(PENDING));
		coffeeChats.addAll(coffeeChatReader.readByFromUser(user, List.of(ACCEPT, REJECT)));

		return coffeeChats;
	}
}
