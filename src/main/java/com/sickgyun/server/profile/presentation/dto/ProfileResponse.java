package com.sickgyun.server.profile.presentation.dto;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Major;

public record ProfileResponse(
	Long userId,
	String name,
	Integer admissionYear,
	String imageUrl,
	Major major,
	String githubUrl,
	String resume,
	String portfolio,
	Boolean isRecruited,
	String company
) {
	public static ProfileResponse from(Profile profile) {
		return new ProfileResponse(
			profile.getWriter().getId(),
			profile.getWriter().getName(),
			profile.getInformation().getAdmissionYear(),
			profile.getInformation().getImageUrl(),
			profile.getInformation().getMajor(),
			profile.getOnlineProfile().getGithubUrl(),
			profile.getOnlineProfile().getResume(),
			profile.getOnlineProfile().getPortfolio(),
			profile.getCompany().getIsRecruited(),
			profile.getCompany().getCompany()
		);
	}
}
