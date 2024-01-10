package com.sickgyun.server.user.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCreator {

	private final UserRepository repository;

	public User create(User user) {
		return repository.save(user);
	}
}
