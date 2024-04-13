package com.sickgyun.server.user.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;
import com.sickgyun.server.user.domain.value.Contact;
import com.sickgyun.server.user.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserUpdater {
	private final UserRepository userRepository;

	public User updateUser(User user) {
		User updatableUser = userRepository.findUserByEmail(user.getEmail())
			.orElseThrow(() -> new UserNotFoundException(user.getEmail()));

		updatableUser.update(user);

		return updatableUser;
	}

	public void updateContact(User updatableUser, Contact contact) {
		updatableUser.updateContact(contact);
		userRepository.save(updatableUser);
	}
}
