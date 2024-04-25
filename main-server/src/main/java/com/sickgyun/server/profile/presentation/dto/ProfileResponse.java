package com.sickgyun.server.profile.presentation.dto;

import java.time.LocalDateTime;

import org.jsoup.internal.StringUtil;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Major;

public record ProfileResponse(
	Long id,
	String name,
	String imageUrl,
	Boolean isGraduated,
	Boolean isRecruited,
	Major major,
	String githubId,
	String resumeUrl,
	String portfolioUrl,
	String company,
	Long cardinal,
	String introduction
) {
	public static ProfileResponse from(Profile profile) {
		return new ProfileResponse(
			profile.getId(),
			profile.getWriter().getName(),
			profile.getInformation().getImageUrl(),
			LocalDateTime.now().getYear() - profile.getWriter().getCardinal() >= 2023,
			!StringUtil.isBlank(profile.getCompany()),
			profile.getInformation().getMajor(),
			profile.getOnlineProfile().getGithubId(),
			profile.getOnlineProfile().getResumeUrl(),
			profile.getOnlineProfile().getPortfolioUrl(),
			profile.getCompany(),
			profile.getWriter().getCardinal(),
			profile.getInformation().getIntroduction()
		);
	}
}
