package com.sickgyun.server.auth.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class NotBssmEmailException extends SickgyunException {
	public NotBssmEmailException(String email) {
		super(HttpStatus.BAD_REQUEST, email + "은 Bssm 이메일이 아닙니다.");
	}
}
