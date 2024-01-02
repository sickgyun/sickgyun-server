package com.sickgyun.server.user.service;

import org.springframework.stereotype.Service;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTempService {
	private final UserRepository userRepository;

	public User getUserId1() {
		return userRepository.findById(1L)
			.orElseThrow(RuntimeException::new);
	}
}
