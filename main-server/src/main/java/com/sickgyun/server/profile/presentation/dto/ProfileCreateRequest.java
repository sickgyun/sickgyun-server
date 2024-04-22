package com.sickgyun.server.profile.presentation.dto;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Information;
import com.sickgyun.server.profile.domain.value.Major;
import com.sickgyun.server.profile.domain.value.OnlineProfile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProfileCreateRequest(
	String imageUrl,
	@NotNull @Size(max = 1000) String introduction,
	@NotNull String githubId,
	@NotNull Major major,
	String resumeUrl,
	Boolean isRecruited,
	String company,
	String portfolioUrl
) {

	public ProfileCreateRequest(String imageUrl, @NotNull String introduction, @NotNull String githubId,
		@NotNull Major major, String resumeUrl, Boolean isRecruited, String company, String portfolioUrl) {
		if (imageUrl == null || imageUrl.isEmpty()) {
			this.imageUrl = "https://sickgyun.s3.ap-northeast-2.amazonaws.com/filef531b003-1bf7-4a0e-bf3b-c06e8471db05";
		} else {
			this.imageUrl = imageUrl;
		}
		this.introduction = introduction;
		this.githubId = githubId;
		this.major = major;
		this.resumeUrl = resumeUrl;
		this.isRecruited = isRecruited;
		this.company = company;
		this.portfolioUrl = portfolioUrl;
	}

	public Profile toEntity() {
		return new Profile(
			new Information(imageUrl, introduction, major),
			company,
			new OnlineProfile(githubId, resumeUrl, portfolioUrl)
		);
	}
}
