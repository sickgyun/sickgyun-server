package com.sickgyun.server.recruit.presentation.dto;

import com.sickgyun.server.recruit.domain.Recruit;

public record RecruitResponse(
	Long id,
	String company,
	String imageSrc,
	String reqruitName,
	String skills
) {

	public static RecruitResponse from(Recruit recruit) {
		return new RecruitResponse(
			recruit.getId(),
			recruit.getCompany(),
			recruit.getImageSrc(),
			recruit.getReqruitName(),
			recruit.getSkills()
		);
	}
}
