package com.sickgyun.server.auth.exception;

import static org.springframework.http.HttpStatus.*;

import com.sickgyun.server.common.exception.SickgyunException;

public class UserNotLoginException extends SickgyunException {
	public UserNotLoginException() {
		super(FORBIDDEN, "유저가 로그인하지 않았습니다.");
	}
}
