package com.sickgyun.server.interest.service.implementation;

import org.springframework.stereotype.Service;

import com.sickgyun.server.interest.domain.repository.NotInterestedRepository;
import com.sickgyun.server.interest.domain.type.Type;
import com.sickgyun.server.interest.exception.AlreadyNotInterestedException;
import com.sickgyun.server.interest.exception.TypeNotExistException;
import com.sickgyun.server.reqruit.service.implementation.ReqruitValidator;
import com.sickgyun.server.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterestValidator {
	private final ReqruitValidator reqruitValidator;
	private final NotInterestedRepository notInterestedRepository;

	public void shouldPartyBeExist(Long partyId, Type partyType) {
		if (partyType == Type.REQRUIT) {
			reqruitValidator.requiredShouldBeExist(partyId);
			return;
		}

		throw new TypeNotExistException(partyType);
	}

	public void shouldNotAlreadyNotInterested(User user, Long partyId, Type partyType) {
		boolean isAlreadyExist = notInterestedRepository.existsByUserIdAndPartyIdAndPartyType(user.getId(), partyId,
			partyType);

		if (isAlreadyExist) {
			throw new AlreadyNotInterestedException(partyId);
		}
	}
}
