package com.sickgyun.server.qna.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.service.implementation.AuthReader;
import com.sickgyun.server.qna.presentation.dto.CreateQnARequest;
import com.sickgyun.server.qna.presentation.dto.QnAResponse;
import com.sickgyun.server.qna.service.CommandQnAService;
import com.sickgyun.server.qna.service.QueryQnAService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnAController {

	private final CommandQnAService commandQnAService;
	private final QueryQnAService queryQnAService;
	private final AuthReader authReader;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	@LoginRequired
	public void createQnA(@RequestBody CreateQnARequest request) {
		commandQnAService.createQnA(request.toEntity(), authReader.getCurrentUser());
	}

	@GetMapping
	public List<QnAResponse> findAll(
		@RequestParam(name = "category", required = false, defaultValue = "ALL") String category,
		@RequestParam(name = "criteria", required = false, defaultValue = "id") String criteria
	) {
		return queryQnAService.findAllByCategory(category, criteria).stream()
			.map(QnAResponse::from)
			.toList();
	}

	@GetMapping("/{qna-id}")
	public QnAResponse findOne(@PathVariable(name = "qna-id") Long qnAId) {
		return QnAResponse.from(queryQnAService.findOne(qnAId));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{qna-id}")
	@LoginRequired
	public void updateQnA(
		@PathVariable(name = "qna-id") Long qnAId,
		@RequestBody CreateQnARequest request
	) {
		commandQnAService.updateQnA(qnAId, request.toEntity(), authReader.getCurrentUser());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{qna-id}")
	@LoginRequired
	public void deleteQnA(@PathVariable(name = "qna-id") Long qnAId) {
		commandQnAService.deleteQnA(qnAId, authReader.getCurrentUser());
	}
}
