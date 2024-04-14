package com.sickgyun.server.common.logging;

import com.sickgyun.server.common.exception.SickgyunException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingUtils {
	public static void warn(SickgyunException exception) {
		String message = getExceptionMessage(exception.getMessage());
		log.warn(message + "\n \t {}", exception);
	}

	private static String getExceptionMessage(String message) {
		if (message == null || message.isBlank()) {
			return "";
		}
		return message;
	}

	public static void error(RuntimeException exception) {
		String message = getExceptionMessage(exception.getMessage());
		log.error(message + "\n \t {}", exception);
	}
}
