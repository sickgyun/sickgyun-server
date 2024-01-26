package com.sickgyun.server.interest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.interest.domain.NotInterested;
import com.sickgyun.server.interest.domain.type.Type;

public interface NotInterestedRepository extends JpaRepository<NotInterested, Long> {
	boolean existsByUserIdAndPartyIdAndPartyType(Long userId, Long partyId, Type partyType);
}
