package com.sickgyun.server.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.auth.util.JwtParser;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthReader {
	private final AuthRepository authRepository;
	private final JwtParser jwtParser;

	public Long getIdFromJwt(String token) {
		return jwtParser.getIdFromJwt(token);
	}

	public User getCurrentUser() {
		return authRepository.getCurrentUser();
	}
}
