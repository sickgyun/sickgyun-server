package com.sickgyun.server.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.auth.infra.feign.GoogleOauthFeign;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthReader {
	private final GoogleOauthFeign googleFeign;

	public User getGoogleUser(String accessToken) {
		return googleFeign.getInfo(accessToken).toUser();
	}
}
