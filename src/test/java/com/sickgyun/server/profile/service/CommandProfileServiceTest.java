package com.sickgyun.server.profile.service;

import static com.sickgyun.server.profile.domain.fixture.ProfileFixture.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sickgyun.server.common.ServiceTest;
import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.profile.domain.value.Major;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;

public class CommandProfileServiceTest extends ServiceTest {

	@Autowired
	private CommandProfileService commandProfileService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Test
	void 프로필을_생성한다() {
		//given
		Profile 저장할_프로필 = 프로필_백엔드();
		User 저장된_유저 = 유저_저장(유저);
		//when
		commandProfileService.create(저장할_프로필, 저장된_유저);
		//then
		assertThat(프로필_조회(저장할_프로필).isPresent()).isEqualTo(true);
	}

	@Test
	void 프로필을_업데이트한다() {
		//given
		User 저장된_유저 = 유저_저장(유저);
		Profile 저장할_프로필 = 프로필_프론트();
		Profile 업데이트할_프로필 = 프로필_나머지();

		저장할_프로필.updateWriter(저장된_유저);
		profileRepository.save(저장할_프로필);
		//when
		commandProfileService.update(업데이트할_프로필, 저장된_유저);
		//then
		assertThat(프로필_조회(저장할_프로필).get().getInformation().getMajor())
			.isEqualTo(Major.ETC);
	}

	private Optional<Profile> 프로필_조회(Profile 저장할_프로필) {
		return profileRepository.findById(저장할_프로필.getId());
	}

	private User 유저_저장(User 유저) {
		return userRepository.save(유저);
	}
}
