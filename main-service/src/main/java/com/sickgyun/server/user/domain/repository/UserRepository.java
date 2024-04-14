package com.sickgyun.server.user.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.exception.UserNotFoundException;

public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);

	Optional<User> findUserByEmail(String email);

	default User getById(Long id) {
		return findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}
}
