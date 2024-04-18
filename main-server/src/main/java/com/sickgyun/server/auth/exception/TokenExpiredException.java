package com.sickgyun.server.auth.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class TokenExpiredException extends SickgyunException {
	public TokenExpiredException() {
		super(HttpStatus.FORBIDDEN, "토큰이 만료되었습니다.");
	}
}
