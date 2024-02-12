package com.sickgyun.server.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.value.Contact;
import com.sickgyun.server.user.service.implementation.UserUpdater;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandUserService {

	private final UserUpdater userUpdater;

	public void updateContact(User user, Contact contact) {
		userUpdater.updateContact(user, contact);
	}
}
