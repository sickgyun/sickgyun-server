package com.sickgyun.server.profile.presentation.dto;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Company;
import com.sickgyun.server.profile.domain.value.Information;
import com.sickgyun.server.profile.domain.value.Major;
import com.sickgyun.server.profile.domain.value.OnlineProfile;

import jakarta.validation.constraints.NotNull;

public record ProfileUpdateRequest(
	String imageUrl,
	@NotNull String introduction,
	@NotNull String githubUrl,
	@NotNull Major major,
	@NotNull Integer admissionYear,
	String resume,
	Boolean isRecruited,
	String company,
	String portfolio
) {
	public Profile toEntity() {
		return new Profile(
			new Information(imageUrl, introduction, major, admissionYear),
			new Company(isRecruited, company),
			new OnlineProfile(githubUrl, resume, portfolio)
		);
	}
}
