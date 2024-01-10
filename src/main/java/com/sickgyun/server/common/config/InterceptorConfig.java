package com.sickgyun.server.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sickgyun.server.auth.interceptor.AuthInterceptor;
import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.auth.util.JwtParser;
import com.sickgyun.server.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
	private final JwtParser jwtParser;
	private final AuthRepository authRepository;
	private final UserRepository userRepository;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor(jwtParser, authRepository, userRepository));
	}
}
