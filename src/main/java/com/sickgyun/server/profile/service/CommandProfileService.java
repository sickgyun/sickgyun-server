package com.sickgyun.server.profile.service;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.service.implementation.ProfileCreator;
import com.sickgyun.server.profile.service.implementation.ProfileReader;
import com.sickgyun.server.profile.service.implementation.ProfileValidator;
import com.sickgyun.server.user.domain.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandProfileService {
	private final ProfileCreator profileCreator;
	private final ProfileValidator profileValidator;
	private final ProfileReader profileReader;

	@Transactional
	public void create(Profile profile, User writer) {
		profileValidator.shouldHaveAnotherProfile(writer);

		profileCreator.create(profile, writer);
	}

	@Transactional
	public void update(Profile profile, User writer) {
		Profile updatableProfile = profileReader.findProfileByWriter(writer);

		updatableProfile.update(profile);
	}
}
