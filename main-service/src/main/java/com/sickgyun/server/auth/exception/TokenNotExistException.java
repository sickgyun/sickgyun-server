package com.sickgyun.server.auth.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class TokenNotExistException extends SickgyunException {

	public TokenNotExistException() {
		super(HttpStatus.FORBIDDEN, "토큰이 넘어오지 않았습니다.");
	}
}
