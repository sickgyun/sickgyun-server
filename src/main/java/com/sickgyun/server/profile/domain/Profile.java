package com.sickgyun.server.profile.domain;

import com.sickgyun.server.profile.domain.value.Company;
import com.sickgyun.server.profile.domain.value.Information;
import com.sickgyun.server.profile.domain.value.OnlineProfile;
import com.sickgyun.server.user.domain.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private Long id;

	@Embedded
	private Information information;

	@Embedded
	private Company company;

	@Embedded
	private OnlineProfile onlineProfile;

	@OneToOne(
		cascade = CascadeType.REMOVE,
		orphanRemoval = true,
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "user_id")
	private User writer;

	public Profile(Information information, Company company, OnlineProfile onlineProfile) {
		this.information = information;
		this.company = company;
		this.onlineProfile = onlineProfile;
	}

	public void updateWriter(User writer) {
		writer.updateProfile(this);
		this.writer = writer;
	}

	public void update(Profile profile) {
		this.information = profile.getInformation();
		this.company = profile.getCompany();
		this.onlineProfile = profile.getOnlineProfile();
	}
}
