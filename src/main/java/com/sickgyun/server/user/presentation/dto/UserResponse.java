package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.User;

public record UserResponse(
	Long id,
	String name
) {

	public static UserResponse from(User user) {
		return new UserResponse(user.getId(), user.getName());
	}
}
