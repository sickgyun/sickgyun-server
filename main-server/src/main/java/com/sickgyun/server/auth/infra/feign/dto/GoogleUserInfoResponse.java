package com.sickgyun.server.auth.infra.feign.dto;

import com.sickgyun.server.user.domain.User;

public record GoogleUserInfoResponse(
	String email,
	String name
) {
	public User toUser() {
		return new User(name, email);
	}
}
