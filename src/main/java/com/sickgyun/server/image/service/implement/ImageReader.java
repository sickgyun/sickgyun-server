package com.sickgyun.server.image.service.implement;

import org.springframework.stereotype.Service;

import com.sickgyun.server.image.domain.Image;
import com.sickgyun.server.image.domain.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageReader {
	private final ImageRepository imageRepository;

	public Image read(Long id) {
		return imageRepository.getById(id);
	}
}
