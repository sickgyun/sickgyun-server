package com.sickgyun.server.mail.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class EmailNotExistException extends SickgyunException {

	public EmailNotExistException() {
		super(HttpStatus.NOT_FOUND, "찾을 수 없는 이메일 입니다.");
	}
}
