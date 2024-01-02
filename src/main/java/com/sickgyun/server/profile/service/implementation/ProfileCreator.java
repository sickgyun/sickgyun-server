package com.sickgyun.server.profile.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileCreator {
	private final ProfileRepository profileRepository;

	public void create(Profile profile, User writer) {
		profileRepository.save(profile);
		profile.updateWriter(writer);
	}
}
