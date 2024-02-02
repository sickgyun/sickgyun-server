package com.sickgyun.server.recruit.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Recruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recruit_id")
	private Long id;

	private String company;

	private String imageSrc;

	private String reqruitName;

	private String href;

	public Recruit(String company, String imageSrc, String reqruitName, String href) {
		this.company = company;
		this.imageSrc = imageSrc;
		this.reqruitName = reqruitName;
		this.href = href;
	}
}
