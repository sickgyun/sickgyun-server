package com.sickgyun.server.profile.domain.value;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OnlineProfile {
	String githubUrl;
	String resume;
	String portfolio;
}
