package com.sickgyun.server.auth.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class TokenInvalidException extends SickgyunException {
	public TokenInvalidException() {
		super(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다.");
	}
}
