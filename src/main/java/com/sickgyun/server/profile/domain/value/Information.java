package com.sickgyun.server.profile.domain.value;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Information {
	String imageUrl;
	String introduction;
	@Enumerated(EnumType.STRING)
	Major major;
	Integer admissionYear;
}
