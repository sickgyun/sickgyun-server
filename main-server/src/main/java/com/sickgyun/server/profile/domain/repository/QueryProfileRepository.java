package com.sickgyun.server.profile.domain.repository;

import java.util.List;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Filter;

public interface QueryProfileRepository {
	List<Profile> findAllFiltered(Filter filter);
}
