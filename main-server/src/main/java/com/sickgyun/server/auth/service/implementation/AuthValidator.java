package com.sickgyun.server.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.auth.exception.NotBssmEmailException;
import com.sickgyun.server.auth.exception.TokenExpiredException;
import com.sickgyun.server.auth.exception.TokenInvalidException;
import com.sickgyun.server.common.config.JwtCredentials;
import com.sickgyun.server.user.domain.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthValidator {
	private final JwtCredentials jwtCredentials;

	public void shouldBeBssmEmail(User user) {
		String email = user.getEmail();

		if (!email.endsWith("@bssm.hs.kr")) {
			throw new NotBssmEmailException(email);
		}
	}

	public void shouldRefreshTokenValid(String refreshToken) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(jwtCredentials.secretKey())
				.build()
				.parseClaimsJws(refreshToken);
		} catch (ExpiredJwtException e) {
			throw new TokenExpiredException();
		} catch (JwtException e) {
			throw new TokenInvalidException();
		}
	}
}
