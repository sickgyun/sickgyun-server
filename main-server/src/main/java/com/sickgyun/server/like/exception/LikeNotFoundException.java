package com.sickgyun.server.like.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class LikeNotFoundException extends SickgyunException {

	public LikeNotFoundException() {
		super(HttpStatus.NOT_FOUND, "좋아요를 찾을 수 없습니다.");
	}
}
