package com.sickgyun.server.event.scheduler;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sickgyun.server.event.domain.Event;
import com.sickgyun.server.event.domain.repository.EventRepository;
import com.sickgyun.server.event.exception.EventUrlConnectingError;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventScheduler {

	@Value("${event.url}")
	private String url;
	private final EventRepository eventRepository;

	// @Scheduled(cron = "0 0 5 ? * MON") // 매주 월요일 5시
	@Scheduled(cron = "*/10 * * * * *")
	@Transactional
	public void getReqruitInformation() {
		YearMonth now = YearMonth.now();
		YearMonth nextMonth = now.plusMonths(1);

		List<Event> thisMonthEvent = getEventsByMonth(now);
		List<Event> nextMonthEvent = getEventsByMonth(nextMonth);

		List<Event> allEvents = Stream.of(thisMonthEvent, nextMonthEvent)
			.flatMap(Collection::stream)
			.toList();

		eventRepository.deleteAll();
		eventRepository.saveAll(allEvents);
	}

	private List<Event> getEventsByMonth(YearMonth date) {
		Document document = connectToServer(date);
		Elements rawEvents = getRawEvents(document);
		return getAllEvents(rawEvents, date);
	}

	private static List<Event> getAllEvents(Elements rawEvents, YearMonth yearMonth) {
		List<Event> events = new ArrayList<>();

		for (Element rawReqruit : rawEvents) {
			String imageSrc = "https://dev-event.vercel.app/" + rawReqruit.select("img").get(2).attr("src");
			String name = rawReqruit.getElementsByClass("Item_item__content__title___fPQa").text();
			String host = rawReqruit.getElementsByClass("Item_host__zNXMy").text();
			String date = rawReqruit.getElementsByClass("Item_date__kVMJZ").text();
			String href = rawReqruit.getElementsByTag("a").get(0).attr("href");
			String hashtags = rawReqruit.getElementsByClass("Item_tags___ujeV").text()
				.replace(" ", "")
				.replace("#", " #")
				.substring(1);

			events.add(
				new Event(
					imageSrc,
					name,
					host,
					date,
					href,
					hashtags,
					yearMonth
				)
			);

		}
		return events;
	}

	private static Elements getRawEvents(Document document) {
		return document.getElementsByClass("Item_item__86e_I");
	}

	private Document connectToServer(YearMonth date) {
		Document document;
		try {
			document = Jsoup.connect(String.format(url, date.getYear(), date.getMonth().getValue())).get();
		} catch (IOException e) {
			throw new EventUrlConnectingError();
		}
		return document;
	}
}
