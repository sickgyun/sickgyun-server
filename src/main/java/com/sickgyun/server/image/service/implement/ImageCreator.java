package com.sickgyun.server.image.service.implement;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.sickgyun.server.common.config.S3Bucket;
import com.sickgyun.server.image.domain.Image;
import com.sickgyun.server.image.domain.repository.ImageRepository;
import com.sickgyun.server.image.exception.S3SaveException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageCreator {
	private final S3Bucket s3Bucket;
	private final AmazonS3 amazonS3;
	private final ImageRepository imageRepository;

	public Image create(MultipartFile multipartFile) {
		String fileName = createFileName(multipartFile);

		try {
			PutObjectRequest request = new PutObjectRequest(
				s3Bucket.getS3Bucket(),
				fileName,
				multipartFile.getInputStream(),
				getMetadata(multipartFile)
			);

			amazonS3.putObject(request);
		} catch (IOException e) {
			throw new S3SaveException();
		}
		String url = amazonS3.getUrl(s3Bucket.getS3Bucket(), fileName).toString();

		return imageRepository.save(new Image(fileName, url));
	}

	private String createFileName(MultipartFile multipartFile) {
		return multipartFile.getName() + UUID.randomUUID();
	}

	private ObjectMetadata getMetadata(MultipartFile file) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		metadata.setContentType(file.getContentType());
		return metadata;
	}
}
