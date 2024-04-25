package com.sickgyun.server.profile.service;

import static com.sickgyun.server.profile.domain.fixture.ProfileFixture.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sickgyun.server.common.ServiceTest;
import com.sickgyun.server.profile.domain.Profile;
import com.sickgyun.server.profile.domain.repository.ProfileRepository;
import com.sickgyun.server.profile.domain.value.Filter;
import com.sickgyun.server.profile.domain.value.Major;
import com.sickgyun.server.user.domain.User;
import com.sickgyun.server.user.domain.repository.UserRepository;

public class QueryProfileServiceTest extends ServiceTest {
	@Autowired
	private QueryProfileService queryProfileService;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void 전체_조회한다() {
		//given
		전체_저장(프로필_백엔드(), 프로필_프론트(), 프로필_나머지());

		//when
		List<Profile> 전체_조회 = 필터링_없이_조회();
		List<Profile> 취업한_사람_조회 = 취업한_사람만_조회();
		// List<Profile> 입학년도가_2021인_사람 = 입학년도가_2021년인_사람_조회();
		List<Profile> 전공이_ETC인_사람 = 전공이_ETC인_사람();
		List<Profile> 전공이_GAME_혹은_BACKEND_이고_취업한_사람 = 전공이_GAME_혹은_BACKEND_이고_취업한_사람();

		//then
		assertAll(
			() -> assertThat(전체_조회.size()).isEqualTo(3),
			() -> assertThat(취업한_사람_조회.size()).isEqualTo(2),
			// () -> assertThat(입학년도가_2021인_사람.size()).isEqualTo(1),
			() -> assertThat(전공이_ETC인_사람.size()).isEqualTo(1),
			() -> assertThat(전공이_GAME_혹은_BACKEND_이고_취업한_사람.size()).isEqualTo(0)
		);
	}

	@Test
	void 프로필을_단건_조회한다() {
		//given
		Long profileId = 저장_후_Id_반환(프로필_백엔드());
		//when
		Optional<Profile> 아이디로_조회 = 아이디로_조회(profileId);
		//then
		assertThat(아이디로_조회.isPresent()).isEqualTo(true);
	}

	@Test
	void 자신의_프로필_조회한다() {
		//given
		User 유저 = 프로필_백엔드_유저_저장();
		//then
		assertDoesNotThrow(() -> queryProfileService.readMine(유저));
	}

	private User 프로필_백엔드_유저_저장() {
		User 백엔드_유저 = 유저;
		Profile 프로필 = 프로필_백엔드();

		profileRepository.save(프로필);
		userRepository.save(백엔드_유저);

		프로필.updateWriter(백엔드_유저);
		백엔드_유저.updateProfile(프로필);

		profileRepository.save(프로필);

		return 백엔드_유저;

	}

	private Optional<Profile> 아이디로_조회(Long profileId) {
		return profileRepository.findById(profileId);
	}

	private Long 저장_후_Id_반환(Profile profile) {
		return profileRepository.save(profile).getId();
	}

	private List<Profile> 전공이_ETC인_사람() {
		return queryProfileService.readAll(new Filter(null, List.of(Major.ETC), null));
	}

	private List<Profile> 전공이_GAME_혹은_BACKEND_이고_취업한_사람() {
		return queryProfileService.readAll(new Filter(true, List.of(Major.GAME, Major.BACKEND), null));
	}

	private List<Profile> 입학년도가_2021년인_사람_조회() {
		return queryProfileService.readAll(new Filter(null, null, 2L));
	}

	private List<Profile> 취업한_사람만_조회() {
		return queryProfileService.readAll(new Filter(true, null, null));
	}

	private List<Profile> 필터링_없이_조회() {
		return queryProfileService.readAll(new Filter(null, null, null));
	}

	private void 전체_저장(Profile... profiles) {
		List<Profile> list = Arrays.stream(profiles).toList();

		for (Profile profile : list) {
			profileRepository.save(profile);
		}
	}
}
