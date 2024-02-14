package com.sickgyun.server.image.service.implement;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.sickgyun.server.common.config.S3Bucket;
import com.sickgyun.server.image.domain.Image;
import com.sickgyun.server.image.domain.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageDeleter {
	private final S3Bucket s3Bucket;
	private final AmazonS3 amazonS3;
	private final ImageRepository imageRepository;

	public void delete(Long id) {
		Image byId = imageRepository.getById(id);
		amazonS3.deleteObject(s3Bucket.getS3Bucket(), byId.getFileName());
	}
}
