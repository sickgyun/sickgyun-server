package com.sickgyun.server.auth.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class TokenMissingException extends SickgyunException {
	public TokenMissingException() {
		super(HttpStatus.UNAUTHORIZED, "토큰이 없습니다.");
	}
}
