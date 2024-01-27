package com.sickgyun.server.reqruit.presentation.dto;

import com.sickgyun.server.reqruit.domain.Reqruit;

public record ReqruitResponse(
	Long id,
	String company,
	String imageSrc,
	String reqruitName,
	String skills
) {

	public ReqruitResponse(Reqruit reqruit) {
		this(
			reqruit.getId(),
			reqruit.getCompany(),
			reqruit.getImageSrc(),
			reqruit.getReqruitName(),
			reqruit.getSkills()
		);
	}
}
