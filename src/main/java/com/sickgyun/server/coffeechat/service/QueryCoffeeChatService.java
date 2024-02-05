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

	public List<CoffeeChat> getPendingByToUser(User user) {
		return coffeeChatReader.readByToUser(user, List.of(PENDING));
	}

	public List<CoffeeChat> getNotPendingByToUser(User user) {
		return coffeeChatReader.readByToUser(user, List.of(ACCEPT, REJECT, TIME));
	}

	public List<CoffeeChat> getPendingByFromUser(User user) {
		return coffeeChatReader.readByFromUser(user, List.of(PENDING));
	}

	public List<CoffeeChat> getNotPendingByFromUser(User user) {
		return coffeeChatReader.readByFromUser(user, List.of(ACCEPT, REJECT, TIME));
	}
}
