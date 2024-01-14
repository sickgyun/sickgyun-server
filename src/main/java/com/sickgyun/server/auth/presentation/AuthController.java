package com.sickgyun.server.auth.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.presentation.dto.AccessTokenRequest;
import com.sickgyun.server.auth.presentation.dto.TokenResponse;
import com.sickgyun.server.auth.service.CommandAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final CommandAuthService authService;

	@PostMapping("/login")
	public TokenResponse login(@RequestBody AccessTokenRequest accessToken) {
		return TokenResponse.from(
			authService.login(accessToken.accessToken())
		);
	}
}
