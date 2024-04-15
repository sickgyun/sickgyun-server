package com.sickgyun.server.domain.logging;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CorsConfig implements WebMvcConfigurer {

	private static final String ALLOW_ALL_PATH = "/**";
	private static final String ALLOWED_METHODS = "*";
	private static final String MAIN_SERVER_DOMAIN = "https://sickgyun.com";
	private static final String FRONTEND_LOCALHOST = "http://localhost:3000";
	private static final String HTTPS_FRONTEND_LOCALHOST = "https://localhost:3000";

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(ALLOW_ALL_PATH)
			.allowedMethods(ALLOWED_METHODS)
			.allowedOrigins(
				MAIN_SERVER_DOMAIN,
				FRONTEND_LOCALHOST,
				HTTPS_FRONTEND_LOCALHOST
			)
			.allowCredentials(true)
			.exposedHeaders(LOCATION, SET_COOKIE);
	}
}
