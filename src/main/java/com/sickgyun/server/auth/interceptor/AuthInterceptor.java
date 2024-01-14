package com.sickgyun.server.auth.interceptor;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sickgyun.server.auth.annotation.AdminOnly;
import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.exception.UserIsNotAdminException;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.auth.service.implementation.AuthUpdater;
import com.sickgyun.server.auth.util.BearerTokenExtractor;
import com.sickgyun.server.auth.util.JwtParser;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.role.Role;
import com.sickgyun.server.user.service.implementation.UserReader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
	private final JwtParser jwtParser;
	private final AuthUpdater authUpdater;
	private final AuthReader authReader;
	private final UserReader userReader;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod hm) {
			if (hm.hasMethodAnnotation(LoginRequired.class)) {
				String jwt = BearerTokenExtractor.extract(request.getHeader(AUTHORIZATION));
				Long userId = jwtParser.getIdFromJwt(jwt);

				User user = userReader.readUser(userId);

				authUpdater.updateCurrentUser(user);
			}
			if (hm.hasMethodAnnotation(AdminOnly.class)) {
				User currentUser = authReader.getCurrentUser();
				shouldUserAdmin(currentUser);
			}
		}
		return true;
	}

	private static void shouldUserAdmin(User currentUser) {
		if (currentUser.getRole() != Role.ADMIN) {
			throw new UserIsNotAdminException();
		}
	}
}
