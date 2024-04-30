package com.sickgyun.server.article.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sickgyun.server.article.presentation.dto.ArticleCreateRequest;
import com.sickgyun.server.article.presentation.dto.ArticleResponse;
import com.sickgyun.server.article.presentation.dto.ArticleUpdateRequest;
import com.sickgyun.server.article.service.CommandArticleService;
import com.sickgyun.server.article.service.QueryArticleService;
import com.sickgyun.server.auth.annotation.LoginRequired;
import com.sickgyun.server.auth.service.implementation.AuthReader;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
	private final CommandArticleService commandService;
	private final QueryArticleService queryService;
	private final AuthReader authReader;
	private final CommandArticleService commandArticleService;

	@PostMapping
	@LoginRequired
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ArticleCreateRequest creatRequest) {
		commandService.create(
			creatRequest.toEntity(
				authReader.getCurrentUser()
			)
		);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ArticleResponse> getAll() {
		return queryService.getAll()
			.stream()
			.map(ArticleResponse::new)
			.toList();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ArticleResponse getOne(@PathVariable Long id) {
		return new ArticleResponse(queryService.getOne(id));
	}

	@LoginRequired
	@GetMapping("/mine")
	@ResponseStatus(HttpStatus.OK)
	public List<ArticleResponse> findMine() {
		return queryService.findMine(authReader.getCurrentUser())
			.stream()
			.map(ArticleResponse::new)
			.toList();
	}

	@LoginRequired
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@RequestBody ArticleUpdateRequest updateRequest, @PathVariable Long id) {
		commandService.update(
			updateRequest.toEntity(
				authReader.getCurrentUser()
			),
			id
		);
	}

	@DeleteMapping("/{id}")
	@LoginRequired
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		commandArticleService.delete(id, authReader.getCurrentUser());
	}
}
