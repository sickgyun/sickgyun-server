package com.sickgyun.server.interest.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class AlreadyNotInterestedException extends SickgyunException {
	public AlreadyNotInterestedException(Long partyId) {
		super(HttpStatus.BAD_REQUEST, partyId + "를 이미 관심없음으로 분류하였습니다");
	}
}
