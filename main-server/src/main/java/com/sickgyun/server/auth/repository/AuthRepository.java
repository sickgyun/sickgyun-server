package com.sickgyun.server.auth.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.sickgyun.server.auth.exception.UserNotLoginException;
import com.sickgyun.server.user.domain.User;

@Repository
@RequestScope
public class AuthRepository {
	private User currentUser;

	public User getCurrentUser() {
		if (currentUser == null) {
			throw new UserNotLoginException();
		}
		return currentUser;
	}

	public User getNullableCurrentUser() {
		return currentUser;
	}

	public void updateCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
