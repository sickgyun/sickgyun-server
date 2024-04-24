package com.sickgyun.server.user.presentation.dto;

import java.time.LocalDateTime;

import com.sickgyun.server.user.domain.User;

public record CurrentUserResponse(
	Long id,
	String name,
	String email,
	Boolean isGraduated,
	Long cardinal,
	Boolean hasCreatedProfile,
	Long profileId,
	String phoneNumber,
	String instagramId,
	String kakaoId,
	Boolean hasNotContact
) {

	public static CurrentUserResponse from(User user) {
		return new CurrentUserResponse(
			user.getId(),
			user.getName(),
			user.getEmail(),
			LocalDateTime.now().getYear() - user.getCardinal() >= 2023,
			user.getCardinal(), user.getProfile() != null,
			user.getProfile() == null ? null : user.getProfile().getId(),
			user.getContact().getPhoneNumber(),
			user.getContact().getInstagramId(),
			user.getContact().getKakaoId(),
			user.getContact().getPhoneNumber().isBlank()
				&& user.getContact().getInstagramId().isBlank()
				&& user.getContact().getKakaoId().isBlank()
		);
	}
}
