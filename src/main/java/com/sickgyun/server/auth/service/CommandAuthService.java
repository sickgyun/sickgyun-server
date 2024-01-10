package com.sickgyun.server.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.auth.domain.Token;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.auth.service.implementation.AuthValidator;
import com.sickgyun.server.auth.service.implementation.TokenProvider;
import com.sickgyun.server.auth.util.BearerTokenExtractor;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.implementation.UserCreator;
import com.sickgyun.server.user.service.implementation.UserReader;
import com.sickgyun.server.user.service.implementation.UserUpdater;
import com.sickgyun.server.user.service.implementation.UserValidator;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandAuthService {
	private final TokenProvider tokenProvider;
	private final AuthReader authReader;
	private final AuthValidator authValidator;
	private final UserValidator userValidator;
	private final UserUpdater userUpdater;
	private final UserCreator userCreator;
	private final UserReader userReader;

	public Token login(String accessToken) {
		User user = authReader.getGoogleUser(accessToken);
		authValidator.shouldBeBssmEmail(user);

		User updatedUser;
		if (userValidator.checkUserExist(user)) {
			updatedUser = userUpdater.updateUser(user);
		} else {
			updatedUser = userCreator.create(user);
		}

		return tokenProvider.createNewTokens(updatedUser);
	}

	public Token refresh(String bearer) {
		String refreshToken = BearerTokenExtractor.extract(bearer);
		authValidator.shouldRefreshTokenValid(refreshToken);

		Long userId = authReader.getIdFromJwt(refreshToken);
		String accessToken = tokenProvider.createAccessToken(userReader.readUser(userId));

		return new Token(accessToken, refreshToken);
	}
}
