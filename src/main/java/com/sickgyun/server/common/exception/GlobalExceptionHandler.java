package com.sickgyun.server.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sickgyun.server.common.logging.LoggingUtils;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({SickgyunException.class})
	public ResponseEntity<ErrorResponse> handleDefineException(SickgyunException exception) {
		LoggingUtils.warn(exception);

		return ResponseEntity.status(exception.getStatus())
			.body(new ErrorResponse(exception.getStatus().value(), exception.getMessage()));
	}

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<ErrorResponse> handleDefineException(RuntimeException exception) {
		LoggingUtils.error(exception);

		return ResponseEntity.status(500)
			.body(new ErrorResponse(500, "서버에서 알 수 없는 에러가 발생했습니다."));
	}
}
