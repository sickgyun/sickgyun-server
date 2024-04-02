package com.sickgyun.server.coffeechat.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.repository.CoffeeChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatDeleter {
	private final CoffeeChatRepository coffeeChatRepository;

	public void delete(CoffeeChat coffeeChat) {
		coffeeChatRepository.delete(coffeeChat);
	}
}
