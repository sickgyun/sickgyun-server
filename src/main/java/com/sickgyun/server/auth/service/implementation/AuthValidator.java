package com.sickgyun.server.auth.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.auth.exception.NotBssmEmailException;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthValidator {

	public void shouldBeBssmEmail(User user) {
		String email = user.getEmail();

		if (!email.endsWith("@bssm.hs.kr")) {
			throw new NotBssmEmailException(email);
		}
	}
}
