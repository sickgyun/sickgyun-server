package com.sickgyun.server.user.presentation.dto;

import com.sickgyun.server.user.domain.value.Contact;

import jakarta.validation.constraints.NotNull;

public record ContactRequest(
	@NotNull String phoneNumber,
	@NotNull String instagramId,
	@NotNull String kakaoId
) {
	public Contact toEntity() {
		return new Contact(phoneNumber, instagramId, kakaoId);
	}
}
