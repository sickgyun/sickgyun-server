package com.sickgyun.server.user.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidator {
	private final UserRepository userRepository;

	public boolean checkUserExist(User user) {
		return userRepository.existsByEmail(user.getEmail());
	}
}
