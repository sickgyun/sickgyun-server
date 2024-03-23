package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.User;

public record UserRequest(
	String name,
	String email,
	Long cardinal,
	Boolean isGraduated
) {

	public User toEntity() {
		return new User(name, email, isGraduated, cardinal);
	}
}
