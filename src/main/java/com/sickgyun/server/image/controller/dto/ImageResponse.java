package com.sickgyun.server.image.controller.dto;

import com.sickgyun.server.image.domain.Image;

public record ImageResponse(
	Long id,
	String fileName,
	String url
) {
	public static ImageResponse from(Image image) {
		return new ImageResponse(image.getId(), image.getFileName(), image.getUrl());
	}
}
