package com.sickgyun.server.coffeechat.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.coffeechat.exception.CoffeeChatNotFoundException;
import com.sickgyun.server.user.domain.User;

public interface CoffeeChatRepository extends JpaRepository<CoffeeChat, Long> {

	List<CoffeeChat> findByToUserAndStateInOrderByIdDesc(User toUser, List<State> states);

	List<CoffeeChat> findByFromUserAndStateInOrderByIdDesc(User fromUser, List<State> states);

	default CoffeeChat getById(Long id) {
		return findById(id)
			.orElseThrow(() -> new CoffeeChatNotFoundException(id));
	}

	default List<CoffeeChat> getByToUser(User toUser, List<State> states) {
		return findByToUserAndStateInOrderByIdDesc(toUser, states);
	}

	default List<CoffeeChat> getByFromUser(User user, List<State> states) {
		return findByFromUserAndStateInOrderByIdDesc(user, states);
	}

	Boolean existsByToUserAndState(User currentUser, State state);
}
