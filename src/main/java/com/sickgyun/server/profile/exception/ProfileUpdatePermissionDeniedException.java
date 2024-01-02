package com.sickgyun.server.profile.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class ProfileUpdatePermissionDeniedException extends SickgyunException {
	public ProfileUpdatePermissionDeniedException() {
		super(HttpStatus.UNAUTHORIZED, "다른 사람의 profile을 업데이트 할 수 없습니다.");
	}
}
