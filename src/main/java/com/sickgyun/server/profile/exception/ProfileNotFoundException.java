package com.sickgyun.server.profile.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;
import com.sickgyun.server.user.domain.User;

public class ProfileNotFoundException extends SickgyunException {
	public ProfileNotFoundException(User writer) {
		super(HttpStatus.NOT_FOUND, String.format("%s이 생성한 profile이 없습니다.", writer.getId()));
	}

	public ProfileNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 profile이 없습니다.", id));
	}
}
