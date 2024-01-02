package com.sickgyun.server.profile.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.service.implementation.ProfileCreator;
import com.sickgyun.server.profile.service.implementation.ProfileReader;
import com.sickgyun.server.profile.service.implementation.ProfileValidator;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandProfileService {
	private final ProfileCreator profileCreator;
	private final ProfileValidator profileValidator;
	private final ProfileReader profileReader;

	public void create(Profile profile, User writer) {
		profileValidator.shouldHaveAnotherProfile(writer);

		profileCreator.create(profile, writer);
	}

	public void update(Profile profile, User writer) {
		Profile updatableProfile = profileReader.findProfileByWriter(writer);

		updatableProfile.update(profile);
	}
}
