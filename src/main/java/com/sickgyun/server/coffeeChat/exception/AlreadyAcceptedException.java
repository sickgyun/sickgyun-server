package com.sickgyun.server.coffeeChat.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.coffeeChat.domain.CoffeeChat;
import com.sickgyun.server.common.exception.SickgyunException;

public class AlreadyAcceptedException extends SickgyunException {

	public AlreadyAcceptedException(CoffeeChat coffeeChat) {
		super(HttpStatus.BAD_REQUEST, String.format("%s는 이미 수락된 커피챗입니다.", coffeeChat.getId()));
	}
}
