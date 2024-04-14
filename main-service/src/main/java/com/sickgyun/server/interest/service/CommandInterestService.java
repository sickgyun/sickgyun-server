package com.sickgyun.server.interest.service;

import org.springframework.stereotype.Service;

import com.sickgyun.server.interest.domain.type.Type;
import com.sickgyun.server.interest.service.implementation.InterestCreator;
import com.sickgyun.server.interest.service.implementation.InterestValidator;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandInterestService {
	private final InterestCreator interestCreator;
	private final InterestValidator interestValidator;

	public void createNotInterest(User user, Long partyId, Type partyType) {
		interestValidator.shouldPartyBeExist(partyId, partyType);
		interestValidator.shouldNotAlreadyNotInterested(user, partyId, partyType);
		interestCreator.createNotInterest(
			user.getId(),
			partyId,
			partyType
		);
	}
}
