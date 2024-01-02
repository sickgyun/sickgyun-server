package com.sickgyun.server.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
