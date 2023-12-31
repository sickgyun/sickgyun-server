package com.sickgyun.server.profile.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class AlreadyUploadProfileException extends SickgyunException {
	public AlreadyUploadProfileException(Long writerId) {
		super(HttpStatus.BAD_REQUEST, String.format("%s에게 이미 업로드된 프로필이 있습니다.", writerId));
	}
}
