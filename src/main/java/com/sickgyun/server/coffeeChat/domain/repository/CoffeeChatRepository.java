package com.sickgyun.server.coffeeChat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;
import com.sickgyun.server.coffeeChat.exception.CoffeeChatNotFoundException;

public interface CoffeeChatRepository extends JpaRepository<CoffeeChat, Long> {
	default CoffeeChat getById(Long id) {
		return findById(id)
			.orElseThrow(() -> new CoffeeChatNotFoundException(id));
	}
}
