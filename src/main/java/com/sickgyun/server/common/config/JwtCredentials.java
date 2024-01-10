package com.sickgyun.server.common.config;

import static io.jsonwebtoken.security.Keys.*;
import static java.nio.charset.StandardCharsets.*;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "jwt")
public record JwtCredentials(
	SecretKey secretKey,
	long accessTokenExpirationTime,
	long refreshTokenExpirationTime
) {

	@ConstructorBinding
	public JwtCredentials(String secretKey, long accessTokenExpirationTime, long refreshTokenExpirationTime) {
		this(
			hmacShaKeyFor(secretKey.getBytes(UTF_8)),
			accessTokenExpirationTime,
			refreshTokenExpirationTime
		);
	}
}
