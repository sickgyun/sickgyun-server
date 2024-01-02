package com.sickgyun.server.user.domain;

import com.sickgyun.server.profile.domain.Profile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(
		cascade = CascadeType.REMOVE,
		orphanRemoval = true,
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "PROFILE")
	Profile profile;

	public void updateProfile(Profile profile) {
		this.profile = profile;
	}
}
