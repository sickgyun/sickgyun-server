package com.sickgyun.server.coffeeChat.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;

public interface CoffeeChatRepository extends JpaRepository<CoffeeChat, Long> {
}
