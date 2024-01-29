package com.sickgyun.server.coffeechat.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.repository.CoffeeChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatReader {

	private final CoffeeChatRepository coffeeChatRepository;

	public CoffeeChat read(Long coffeeChatId) {
		return coffeeChatRepository.getById(coffeeChatId);
	}
}
