package com.sickgyun.server.profile.domain.repository;

import java.util.List;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Filter;

public interface ProfileQueryRepository {
	List<Profile> findAllFiltered(Filter filter);
}
