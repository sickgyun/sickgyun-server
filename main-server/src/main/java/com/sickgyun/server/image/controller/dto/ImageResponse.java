package com.sickgyun.server.image.controller.dto;

public record ImageResponse(
	String url
) {
	public static ImageResponse from(String url) {
		return new ImageResponse(url);
	}
}
