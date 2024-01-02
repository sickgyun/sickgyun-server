package com.sickgyun.server.profile.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.exception.ProfileNotFoundException;
import com.sickgyun.server.user.domain.User;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	boolean existsProfileByWriter(User writer);

	Optional<Profile> findByWriter(User writer);

	default Profile getByWriter(User writer) {
		return findByWriter(writer)
			.orElseThrow(() -> new ProfileNotFoundException(writer.getId()));
	}
}
