package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.value.Contact;

public record UserRequest(
	String name,
	String email,
	Contact contact
) {

	public User toEntity() {
		return new User(name, email, contact);
	}
}
