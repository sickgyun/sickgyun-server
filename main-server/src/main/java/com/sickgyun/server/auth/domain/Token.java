package com.sickgyun.server.auth.domain;

public record Token(
	String accessToken,
	String refreshToken
) {
}
