package com.sickgyun.server.common.config;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sickgyun.server.auth.interceptor.AuthInterceptor;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.auth.service.implementation.AuthUpdater;
import com.sickgyun.server.auth.util.JwtParser;
import com.sickgyun.server.user.service.implementation.UserReader;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

	private static final String ALLOW_ALL_PATH = "/**";
	private static final String ALLOWED_METHODS = "*";
	private static final String MAIN_SERVER_DOMAIN = "https://zipgo.pet";
	private static final String DEV_SERVER_DOMAIN = "https://dev.zipgo.pet";
	private static final String FRONTEND_LOCALHOST = "http://localhost:3000";
	private static final String HTTPS_FRONTEND_LOCALHOST = "https://localhost:3000";

	private final JwtParser jwtParser;
	private final AuthUpdater authUpdater;
	private final AuthReader authReader;
	private final UserReader userReader;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(ALLOW_ALL_PATH)
			.allowedMethods(ALLOWED_METHODS)
			.allowedOrigins(
				MAIN_SERVER_DOMAIN,
				DEV_SERVER_DOMAIN,
				FRONTEND_LOCALHOST,
				HTTPS_FRONTEND_LOCALHOST
			)
			.allowCredentials(true)
			.exposedHeaders(LOCATION, SET_COOKIE);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor(jwtParser, authUpdater, authReader, userReader));
	}
}
