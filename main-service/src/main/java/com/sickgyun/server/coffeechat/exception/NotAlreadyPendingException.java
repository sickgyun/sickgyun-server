package com.sickgyun.server.coffeechat.exception;

import org.springframework.http.HttpStatus;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.common.exception.SickgyunException;

public class NotAlreadyPendingException extends SickgyunException {

	public NotAlreadyPendingException(CoffeeChat coffeeChat) {
		super(HttpStatus.BAD_REQUEST, String.format("%s는 이미 수락됐거나 거절된 커피챗입니다.", coffeeChat.getId()));
	}
}
