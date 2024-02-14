package com.sickgyun.server.image.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sickgyun.server.image.domain.Image;
import com.sickgyun.server.image.service.implement.ImageCreator;
import com.sickgyun.server.image.service.implement.ImageDeleter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommandImageService {
	private final ImageCreator imageCreator;
	private final ImageDeleter imageDeleter;

	public Image uploadImage(MultipartFile file) {
		return imageCreator.create(file);
	}

	public void deleteImage(Long imageId) {
		imageDeleter.delete(imageId);
	}
}
