package com.sickgyun.server.event.domain;

import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String image;

	private String name;

	private String host;

	private String date;

	private String href;

	private String hashTags;

	private int year;

	private int month;

	public Event(String image, String name, String host, String date, String href, String hashTags,
		YearMonth yearMonth) {
		this.image = image;
		this.name = name;
		this.host = host;
		this.date = date;
		this.href = href;
		this.hashTags = hashTags;
		this.year = yearMonth.getYear();
		this.month = yearMonth.getMonth().getValue();
	}
}
