package com.sickgyun.server.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SickgyunException extends RuntimeException {
	private final HttpStatus status;
	private final String message;
}
