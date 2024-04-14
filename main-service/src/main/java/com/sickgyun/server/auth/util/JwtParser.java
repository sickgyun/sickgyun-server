package com.sickgyun.server.auth.util;

import org.springframework.stereotype.Component;

import com.sickgyun.server.auth.exception.TokenExpiredException;
import com.sickgyun.server.auth.exception.TokenInvalidException;
import com.sickgyun.server.common.config.JwtCredentials;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtParser {
	public static final String ID = "id";
	private final JwtCredentials jwtCredentials;

	public Long getIdFromJwt(String jwt) {
		try {
			return Long.parseLong(Jwts.parserBuilder()
				.setSigningKey(jwtCredentials.secretKey())
				.build()
				.parseClaimsJws(jwt)
				.getBody()
				.get(ID)
				.toString());
		} catch (ExpiredJwtException e) {
			throw new TokenExpiredException();
		} catch (JwtException e) {
			throw new TokenInvalidException();
		}
	}
}
