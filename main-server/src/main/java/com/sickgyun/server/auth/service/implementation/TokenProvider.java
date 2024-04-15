package com.sickgyun.server.auth.service.implementation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.sickgyun.server.auth.domain.Token;
import com.sickgyun.server.common.config.JwtCredentials;
import com.sickgyun.server.user.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenProvider {
	private final JwtCredentials jwtCredentials;

	public Token createNewTokens(User user) {
		return new Token(
			createAccessToken(user),
			createRefreshToken(user)
		);
	}

	public String createAccessToken(User user) {
		return createToken(user, jwtCredentials.accessTokenExpirationTime());
	}

	private String createRefreshToken(User user) {
		return createToken(user, jwtCredentials.refreshTokenExpirationTime());
	}

	private String createToken(User user, long expireLength) {
		Date now = new Date();
		Date expiration = new Date(System.currentTimeMillis() + expireLength);
		return Jwts.builder()
			.claim("id", user.getId())
			.setExpiration(expiration)
			.signWith(jwtCredentials.secretKey(), SignatureAlgorithm.HS256)
			.compact();
	}
}
