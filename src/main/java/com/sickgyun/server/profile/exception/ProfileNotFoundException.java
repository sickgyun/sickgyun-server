package com.sickgyun.server.profile.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class ProfileNotFoundException extends SickgyunException {
	public ProfileNotFoundException(Long writerId) {
		super(HttpStatus.NOT_FOUND, String.format("%s이 생성한 profile이 없습니다.", writerId));
	}
}
