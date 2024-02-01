package com.sickgyun.server.coffeechat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.coffeechat.service.implementation.CoffeeChatReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCoffeeChatService {

	private final CoffeeChatReader coffeeChatReader;

	public List<CoffeeChat> getPendingByToUser(User user) {
		return coffeeChatReader.readByToUser(user, State.PENDING);
	}
}
