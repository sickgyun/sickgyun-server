package com.sickgyun.server.profile.presentation.dto;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.sickgyun.server.profile.domain.value.Filter;
import com.sickgyun.server.profile.domain.value.Major;

public record FilterRequest(
	@RequestParam(required = false)
	Boolean isRecruited,
	@RequestParam(required = false)
	List<Major> majors,
	@RequestParam(required = false)
	Long cardinal
) {
	public Filter toDomain() {
		return new Filter(
			isRecruited,
			majors,
			cardinal
		);
	}
}
