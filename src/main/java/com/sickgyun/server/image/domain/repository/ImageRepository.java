package com.sickgyun.server.image.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.image.domain.Image;
import com.sickgyun.server.image.exception.ImageNotFoundException;

public interface ImageRepository extends JpaRepository<Image, Long> {

	default Image getById(Long id) {
		return findById(id)
			.orElseThrow(() -> new ImageNotFoundException(id));
	}
}
