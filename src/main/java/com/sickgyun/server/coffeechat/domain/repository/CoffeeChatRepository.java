package com.sickgyun.server.coffeechat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.exception.CoffeeChatNotFoundException;

public interface CoffeeChatRepository extends JpaRepository<CoffeeChat, Long> {
	default CoffeeChat getById(Long id) {
		return findById(id)
			.orElseThrow(() -> new CoffeeChatNotFoundException(id));
	}
}
