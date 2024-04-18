package com.sickgyun.server.auth.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class UserIsNotAdminException extends SickgyunException {
	public UserIsNotAdminException() {
		super(HttpStatus.UNAUTHORIZED, "사용자가 어드민이 아닙니다.");
	}
}
