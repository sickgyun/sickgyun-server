package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.User;

public record UserResponse(
	Long id,
	String name,
	String email,
	Boolean isGraduated,
	Long cardinal,
	Boolean hasCreatedProfile,
	Long profileId
) {

	public static UserResponse from(User user) {
		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getIsGraduated(),
			user.getCardinal(), user.getHasCreatedProfile(),
			user.getProfile() == null ? null : user.getProfile().getId());
	}
}
