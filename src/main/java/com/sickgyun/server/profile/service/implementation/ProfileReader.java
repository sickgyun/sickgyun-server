package com.sickgyun.server.profile.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileQueryRepository;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.profile.domain.value.Filter;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileReader {
	private final ProfileRepository profileRepository;
	private final ProfileQueryRepository queryRepository;

	public Profile findProfileByWriter(User writer) {
		return profileRepository.getByWriter(writer);
	}

	public List<Profile> readAll(Filter filter) {
		return queryRepository.findAllFiltered(filter);
	}

	public Profile readById(Long profileId) {
		return profileRepository.getById(profileId);
	}
}
