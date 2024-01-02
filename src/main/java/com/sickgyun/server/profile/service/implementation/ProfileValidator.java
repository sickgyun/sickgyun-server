package com.sickgyun.server.profile.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.profile.exception.AlreadyUploadProfileException;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileValidator {
	private final ProfileRepository profileRepository;

	public void shouldHaveAnotherProfile(User writer) {
		boolean isExist = profileRepository.existsProfileByWriter(writer);

		if (isExist) {
			throw new AlreadyUploadProfileException();
		}
	}
}
