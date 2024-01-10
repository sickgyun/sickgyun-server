package com.sickgyun.server.auth.interceptor;

import static org.springframework.http.HttpHeaders.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sickgyun.server.auth.annotation.AdminOnly;
import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.exception.UserIsNotAdminException;
import com.sickgyun.server.auth.repository.AuthRepository;
import com.sickgyun.server.auth.util.BearerTokenExtractor;
import com.sickgyun.server.auth.util.JwtParser;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;
import com.sickgyun.server.user.domain.role.Role;
import com.sickgyun.server.user.exception.UserNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
	private final JwtParser jwtParser;
	private final AuthRepository authRepository;
	private final UserRepository userRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod hm) {
			if (hm.hasMethodAnnotation(LoginRequired.class)) {
				String jwt = BearerTokenExtractor.extract(request.getHeader(AUTHORIZATION));
				Long userId = jwtParser.getIdFromJwt(jwt);

				User user = userRepository.findById(userId)
					.orElseThrow(() -> new UserNotFoundException(userId));

				authRepository.updateCurrentUser(user);
			}
			if (hm.hasMethodAnnotation(AdminOnly.class)) {
				User currentUser = authRepository.getCurrentUser();
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
