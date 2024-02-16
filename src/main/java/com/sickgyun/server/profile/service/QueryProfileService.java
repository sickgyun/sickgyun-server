package com.sickgyun.server.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Filter;
import com.sickgyun.server.profile.service.implementation.ProfileReader;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryProfileService {
	private final ProfileReader profileReader;

	public List<Profile> readAll(Filter filter) {
		return profileReader.readAll(filter);
	}

	public Profile readOne(Long profileId) {
		return profileReader.readById(profileId);
	}

	public Profile readMine(User user) {
		return profileReader.readByUser(user);
	}
}
