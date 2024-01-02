package com.sickgyun.server.profile.domain.value;

import jakarta.persistence.Embeddable;
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
	String major;
	String admissionYear;
}
