package com.sickgyun.server.auth.presentation.dto;

import com.sickgyun.server.auth.domain.Token;

public record TokenResponse(
	String accessToken,
	String refreshToken
) {
	public static TokenResponse from(Token token) {
		return new TokenResponse(
			token.accessToken(),
			token.refreshToken()
		);
	}
}
