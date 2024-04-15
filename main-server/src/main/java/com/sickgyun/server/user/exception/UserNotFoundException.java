package com.sickgyun.server.user.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class UserNotFoundException extends SickgyunException {
	public UserNotFoundException(String email) {
		super(HttpStatus.NOT_FOUND, email + "이 이메일인 학생이 없습니다.");
	}

	public UserNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND, id + "인 아이디가 학생이 없습니다.");
	}
}
