package com.sickgyun.server.profile.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileDeleter {
	private final ProfileReader profileReader;
	private final ProfileRepository profileRepository;

	public void deleteByUser(User currentUser) {
		Profile profile = profileReader.findProfileByWriter(currentUser);

		profileRepository.delete(profile);
	}
}
