package com.sickgyun.server.profile.service;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.service.implementation.ProfileCreator;
import com.sickgyun.server.profile.service.implementation.ProfileValidator;
import com.sickgyun.server.user.domain.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileCommandService {
	private final ProfileCreator profileCreator;
	private final ProfileValidator profileValidator;

	@Transactional
	public void create(Profile profile, User writer) {
		profileValidator.hasAnotherProfile(writer);

		profileCreator.create(profile, writer);
	}
}