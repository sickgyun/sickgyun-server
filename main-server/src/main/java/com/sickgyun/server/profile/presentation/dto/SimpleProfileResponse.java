package com.sickgyun.server.profile.presentation.dto;

import org.jsoup.internal.StringUtil;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Major;

public record SimpleProfileResponse(
	Long id,
	String name,
	String imageUrl,
	Major major,
	String company,
	String introduction,
	Long cardinal,
	Long userId,
	Boolean isRecruited,
	String githubId,
	String resumeUrl,
	String portfolioUrl
) {
	public static SimpleProfileResponse from(Profile profile) {
		String introduction = profile.getInformation().getIntroduction();
		if (introduction != null && introduction.length() >= 20) {
			introduction = introduction.substring(0, 20);
		}

		return new SimpleProfileResponse(
			profile.getId(),
			profile.getWriter().getName(),
			profile.getInformation().getImageUrl(),
			profile.getInformation().getMajor(),
			profile.getCompany(),
			introduction,
			profile.getWriter().getCardinal(),
			profile.getWriter().getId(),
			!StringUtil.isBlank(profile.getCompany()),
			profile.getOnlineProfile().getGithubId(),
			profile.getOnlineProfile().getResumeUrl(),
			profile.getOnlineProfile().getPortfolioUrl()
		);
	}
}
