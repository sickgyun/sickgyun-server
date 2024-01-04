package com.sickgyun.server.profile.domain.value;

import java.util.List;

public record Filter(
	Boolean isReqruited,
	List<Major> majors,
	String admissionYear
) {
}
