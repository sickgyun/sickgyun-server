package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.value.Contact;

public record UserResponse(
	Long id,
	String name,
	String email,
	Contact contact
) {

	public static UserResponse from(User user) {
		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getContact());
	}
}
