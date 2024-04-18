package com.sickgyun.server.image.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sickgyun.server.image.service.implement.ImageCreator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandImageService {
	private final ImageCreator imageCreator;

	public String uploadImage(MultipartFile file) {
		return imageCreator.create(file);
	}
}
