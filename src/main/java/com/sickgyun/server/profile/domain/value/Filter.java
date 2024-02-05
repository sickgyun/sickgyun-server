package com.sickgyun.server.profile.domain.value;

import java.util.List;

public record Filter(
	Boolean isRecruited,
	List<Major> majors,
	String admissionYear
) {
}
