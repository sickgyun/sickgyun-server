package com.sickgyun.server.profile.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileReader {
	private final ProfileRepository profileRepository;

	public Profile findProfileByWriter(User writer) {
		return profileRepository.getByWriter(writer);
	}
}
