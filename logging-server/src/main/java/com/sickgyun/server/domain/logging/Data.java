package com.sickgyun.server.domain.logging;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document("data")
public class Data {
	private String name;
	private Map<String, Object> params;
}
