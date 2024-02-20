package com.sickgyun.server.image.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sickgyun.server.image.controller.dto.ImageResponse;
import com.sickgyun.server.image.service.CommandImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
	private final CommandImageService commandImageService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ImageResponse upload(MultipartFile file) {
		return ImageResponse.from(
			commandImageService.uploadImage(file)
		);
	}
}
