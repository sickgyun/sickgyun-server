package com.sickgyun.server.interest.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.interest.domain.NotInterested;
import com.sickgyun.server.interest.domain.repository.NotInterestedRepository;
import com.sickgyun.server.interest.domain.type.Type;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterestCreator {
	private final NotInterestedRepository notInterestedRepository;

	public void createNotInterest(Long userId, Long partyId, Type partyType) {
		notInterestedRepository.save(
			new NotInterested(
				userId,
				partyId,
				partyType
			)
		);
	}
}
