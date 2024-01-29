package com.sickgyun.server.recruit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.recruit.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
}
