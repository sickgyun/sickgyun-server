package com.sickgyun.server.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.auth.domain.Token;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.auth.service.implementation.AuthValidator;
import com.sickgyun.server.auth.service.implementation.TokenProvider;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.service.implementation.UserCreator;
import com.sickgyun.server.user.service.implementation.UserUpdater;
import com.sickgyun.server.user.service.implementation.UserValidator;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandAuthService {
	private final TokenProvider tokenProvider;
	private final AuthReader authReader;
	private final AuthValidator validator;
	private final UserValidator userValidator;
	private final UserUpdater userUpdater;
	private final UserCreator userCreator;

	public Token login(String accessToken) {
		User user = authReader.getGoogleUser(accessToken);
		validator.shouldBeBssmEmail(user);

		User updatedUser;
		if (userValidator.checkUserExist(user)) {
			updatedUser = userUpdater.updateUser(user);
		} else {
			updatedUser = userCreator.create(user);
		}

		return tokenProvider.createNewTokens(updatedUser);
	}
}
