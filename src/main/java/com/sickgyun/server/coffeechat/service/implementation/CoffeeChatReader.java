package com.sickgyun.server.coffeechat.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.repository.CoffeeChatRepository;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatReader {

	private final CoffeeChatRepository coffeeChatRepository;

	public CoffeeChat read(Long coffeeChatId) {
		return coffeeChatRepository.getById(coffeeChatId);
	}

	public List<CoffeeChat> readByToUser(User user, List<State> states) {
		return coffeeChatRepository.getByToUser(user, states);
	}

	public List<CoffeeChat> readByFromUser(User user, List<State> states) {
		return coffeeChatRepository.getByFromUser(user, states);
	}

	public Boolean hasPendingCoffeeChatRequest(User currentUser) {
		return coffeeChatRepository.existsByToUserAndState(currentUser, State.PENDING);
	}
}
