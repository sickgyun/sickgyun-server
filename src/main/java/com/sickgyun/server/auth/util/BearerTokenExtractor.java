package com.sickgyun.server.auth.util;

import static org.springframework.http.HttpHeaders.*;

import com.sickgyun.server.auth.exception.TokenInvalidException;
import com.sickgyun.server.auth.exception.TokenMissingException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BearerTokenExtractor {

	private static final String BEARER_TYPE = "Bearer ";
	private static final String BEARER_JWT_REGEX = "^Bearer [A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$";

	public static String extract(HttpServletRequest request) {
		String authorization = request.getHeader(AUTHORIZATION);
		validate(authorization);
		return authorization.replace(BEARER_TYPE, "").trim();
	}

	private static void validate(String authorization) {
		if (authorization == null) {
			throw new TokenMissingException();
		}
		if (!authorization.matches(BEARER_JWT_REGEX)) {
			throw new TokenInvalidException();
		}
	}

}
