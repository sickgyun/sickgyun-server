package com.sickgyun.server.profile.presentation.dto;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Major;

public record ProfileResponse(
	Long id,
	String name,
	String imageUrl,
	Boolean isGraduated,
	Major major,
	String githubId,
	String resumeUrl,
	String portfolioUrl,
	Boolean isRecruited,
	String company,
	Long cardinal,
	String introduction
) {
	public static ProfileResponse from(Profile profile) {
		return new ProfileResponse(
			profile.getId(),
			profile.getWriter().getName(),
			profile.getInformation().getImageUrl(),
			profile.getWriter().getIsGraduated(),
			profile.getInformation().getMajor(),
			profile.getOnlineProfile().getGithubId(),
			profile.getOnlineProfile().getResumeUrl(),
			profile.getOnlineProfile().getPortfolioUrl(),
			profile.getCompany().getIsRecruited(),
			profile.getCompany().getCompany(),
			profile.getWriter().getCardinal(),
			profile.getInformation().getIntroduction()
		);
	}
}
