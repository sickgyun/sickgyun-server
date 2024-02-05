package com.sickgyun.server.user.domain.value;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	String phone;
	String instagram;
	String kakao;
}
