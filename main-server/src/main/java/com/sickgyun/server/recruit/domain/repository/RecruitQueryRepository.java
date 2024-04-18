package com.sickgyun.server.recruit.domain.repository;

import java.util.List;

import com.sickgyun.server.recruit.domain.Recruit;
import com.sickgyun.server.user.domain.User;

public interface RecruitQueryRepository {
	List<Recruit> findWithoutNotInterested(User user, Long size);
}
