package com.sickgyun.server.profile.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.user.domain.User;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	@Query("select p from Profile p where p.writer = :writer")
	Optional<Profile> findProfileByWriter(@Param("writer") User writer);
}
