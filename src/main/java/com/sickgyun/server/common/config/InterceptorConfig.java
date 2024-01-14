package com.sickgyun.server.common.config;

import org.springframework.context.annotation.Configuration;
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
	private final JwtParser jwtParser;
	private final AuthUpdater authUpdater;
	private final AuthReader authReader;
	private final UserReader userReader;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor(jwtParser, authUpdater, authReader, userReader));
	}
}
