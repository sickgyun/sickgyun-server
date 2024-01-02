package com.sickgyun.server.profile.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.profile.exception.AlreadyUploadProfileException;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileValidator {
	private final ProfileRepository profileRepository;

	public void hasAnotherProfile(User writer) {
		Optional<Profile> foundProfile = profileRepository.findProfileByWriter(writer);

		if (foundProfile.isPresent()) {
			throw new AlreadyUploadProfileException();
		}
	}
}
