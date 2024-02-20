package com.sickgyun.server.image.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class S3SaveException extends SickgyunException {
	public S3SaveException() {
		super(HttpStatus.INTERNAL_SERVER_ERROR, "사진을 s3에 저장하던 중 오류가 발생하였습니다.");
	}
}
