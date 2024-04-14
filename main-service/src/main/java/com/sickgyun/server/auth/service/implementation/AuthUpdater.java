package com.sickgyun.server.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthUpdater {
	private final AuthRepository authRepository;

	public void updateCurrentUser(User user) {
		authRepository.updateCurrentUser(user);
	}
}
