package com.sickgyun.server.profile.domain.fixture;

import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.value.Company;
import com.sickgyun.server.profile.domain.value.Information;
import com.sickgyun.server.profile.domain.value.Major;
import com.sickgyun.server.profile.domain.value.OnlineProfile;
import com.sickgyun.server.user.domain.User;

public class ProfileFixture {

	public static User 유저 = new User(
		"사용자",
		"2022061@bssm.hs.kr"
	);

	public static Profile 프로필_백엔드() {
		return new Profile(
			new Information("imageUrl1", "introduction1", Major.BACKEND),
			new Company(false, ""),
			new OnlineProfile("github1", "resume1", "portfolio1"));
	}

	public static Profile 프로필_프론트() {
		return new Profile(
			new Information("imageUrl2", "introduction2", Major.FRONTEND),
			new Company(true, "당근"),
			new OnlineProfile("github2", "resume2", "portfolio2")
		);
	}

	public static Profile 프로필_나머지() {
		return new Profile(
			new Information("imageUrl2", "introduction2", Major.ETC),
			new Company(true, "토스"),
			new OnlineProfile("github2", "resume2", "portfolio2")
		);
	}
}
