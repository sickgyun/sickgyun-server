package com.sickgyun.server.like.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class AlreadyLikeException extends SickgyunException {

	public AlreadyLikeException() {
		super(HttpStatus.BAD_REQUEST, "이미 좋아요한 QnA입니다.");
	}
}
