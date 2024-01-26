package com.sickgyun.server.coffeeChat.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.common.exception.SickgyunException;

public class CoffeeChatNotFoundException extends SickgyunException {

	public CoffeeChatNotFoundException(Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s의 아이디를 가진 커피챗을 찾을 수 없습니다.", id));
	}
}
