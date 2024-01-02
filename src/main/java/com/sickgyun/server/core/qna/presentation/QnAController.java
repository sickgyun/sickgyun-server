package com.sickgyun.server.core.qna.presentation;

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

import com.sickgyun.server.core.qna.presentation.dto.CreateQnARequest;
import com.sickgyun.server.core.qna.presentation.dto.QnAResponse;
import com.sickgyun.server.core.qna.service.CommandQnAService;
import com.sickgyun.server.core.qna.service.QueryQnAService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnAController {

	private final CommandQnAService commandQnAService;
	private final QueryQnAService queryQnAService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void createQnA(@RequestBody CreateQnARequest request) {
		commandQnAService.createQnA(request.toEntity());
	}

	@GetMapping
	public List<QnAResponse> findAll(
		@RequestParam(name = "category", required = false, defaultValue = "ALL") String category) {
		return queryQnAService.findAllByCategory(category).stream()
			.map(QnAResponse::from)
			.toList();
	}

	@GetMapping("/{qna-id}")
	public QnAResponse findOne(@PathVariable(name = "qna-id") Long qnAId) {
		return QnAResponse.from(queryQnAService.findOne(qnAId));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{qna-id}")
	public void updateQnA(
		@PathVariable(name = "qna-id") Long qnAId,
		@RequestBody CreateQnARequest request
	) {
		commandQnAService.updateQnA(qnAId, request.toEntity());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{qna-id}")
	public void deleteQnA(@PathVariable(name = "qna-id") Long qnAId) {
		commandQnAService.deleteQnA(qnAId);
	}
}
