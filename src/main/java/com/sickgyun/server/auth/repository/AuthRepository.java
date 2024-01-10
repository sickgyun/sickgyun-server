package com.sickgyun.server.auth.repository;

import org.springframework.stereotype.Repository;

import com.sickgyun.server.auth.exception.UserNotLoginException;
import com.sickgyun.server.user.domain.User;

@Repository
public class AuthRepository {
	private User currentUser;

	public User getCurrentUser() {
		if (currentUser == null) {
			throw new UserNotLoginException();
		}
		return currentUser;
	}

	public void updateCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
