package com.sickgyun.server.image.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class ImageNotFoundException extends SickgyunException {
	public ImageNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND, id + "가 id인 이미지가 없습니다.");
	}
}
