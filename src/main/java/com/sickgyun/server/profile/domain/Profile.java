package com.sickgyun.server.profile.domain;

import com.sickgyun.server.profile.domain.value.Company;
import com.sickgyun.server.profile.domain.value.Information;
import com.sickgyun.server.profile.domain.value.OnlineProfile;
import com.sickgyun.server.user.domain.User;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long profileId;

	@Embedded
	Information information;

	@Embedded
	Company company;

	@Embedded
	OnlineProfile onlineProfile;

	@OneToOne(
		mappedBy = "profile",
		fetch = FetchType.EAGER
	)
	User writer;

	public Profile(Information information, Company company, OnlineProfile onlineProfile) {
		this.information = information;
		this.company = company;
		this.onlineProfile = onlineProfile;
	}

	public void updateWriter(User writer) {
		writer.updateProfile(this);
		this.writer = writer;
	}
}
