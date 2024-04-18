package com.sickgyun.server.admin.truncate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/truncate")
@RequiredArgsConstructor
public class DBTruncateController {
	private final JdbcTemplate jdbcTemplate;

	@Value("${admin.password}")
	private String password;

	@PostMapping
	@Transactional
	public void truncate(@RequestBody String password) {
		if (!this.password.equals(password)) {
			throw new IllegalArgumentException("Invalid password");
		}

		jdbcTemplate.execute("set FOREIGN_KEY_CHECKS = 0;");

		jdbcTemplate.execute("TRUNCATE TABLE coffee_chat;");
		jdbcTemplate.execute("TRUNCATE TABLE comment;");
		jdbcTemplate.execute("TRUNCATE TABLE event;");
		jdbcTemplate.execute("TRUNCATE TABLE like_tbl;");
		jdbcTemplate.execute("TRUNCATE TABLE not_interested;");
		jdbcTemplate.execute("TRUNCATE TABLE profile;");
		jdbcTemplate.execute("TRUNCATE TABLE qna;");
		jdbcTemplate.execute("TRUNCATE TABLE recruit;");
		jdbcTemplate.execute("TRUNCATE TABLE user;");

		jdbcTemplate.execute("set FOREIGN_KEY_CHECKS = 1;");
	}
}
