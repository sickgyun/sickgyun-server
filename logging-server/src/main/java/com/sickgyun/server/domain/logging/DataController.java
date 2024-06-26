package com.sickgyun.server.domain.logging;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class DataController {

	private final DataRepository dataRepository;

	@PostMapping
	@Transactional
	public void saveData(@RequestBody Data data) {
		dataRepository.save(data);
	}

}
