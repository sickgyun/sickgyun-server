package com.sickgyun.server.coffeechat.presentation.dto;

public record MessageResponse(
	String message
) {
	public static MessageResponse from(String message) {
		return new MessageResponse(message);
	}
}
