package com.sickgyun.server.profile.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.user.domain.User;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	boolean existsProfileByWriter(User writer);
}
