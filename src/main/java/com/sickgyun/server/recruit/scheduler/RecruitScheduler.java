package com.sickgyun.server.recruit.scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sickgyun.server.recruit.domain.Recruit;
import com.sickgyun.server.recruit.exception.UrlConnectingError;
import com.sickgyun.server.recruit.service.implementation.RecruitCreator;
import com.sickgyun.server.recruit.service.implementation.RecruitDeleter;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitScheduler {
	@Value("${recruit.url}")
	private String url;
	private final RecruitCreator recruitCreator;
	private final RecruitDeleter recruitDeleter;

	@Scheduled(cron = "0 0 5 * * ?") // 매일 오전 5시
	public void getReqruitInformation() {
		Document document = connectToServer();
		Elements rawReqruits = getReqruit(document);
		recruitDeleter.deleteAll();
		recruitCreator.createAll(getAllReqruits(rawReqruits));
	}

	private static List<Recruit> getAllReqruits(Elements rawReqruits) {
		List<Recruit> recruit = new ArrayList<>();

		for (Element rawReqruit : rawReqruits) {
			String imageSrc = rawReqruit.selectFirst("img").attr("src");
			String company = rawReqruit.getElementsByClass("summary__company-name css-x5ccem").text();
			String name = rawReqruit.getElementsByClass("summary__title css-5g43jj").text();
			String stack = rawReqruit.getElementsByClass("css-1py9sy3").text();

			recruit.add(
				new Recruit(
					company,
					imageSrc,
					name,
					stack
				)
			);
		}
		return recruit;
	}

	private static Elements getReqruit(Document document) {
		Elements elementsByClass = document.getElementsByClass("css-pw0enp");
		return elementsByClass;
	}

	private Document connectToServer() {
		Document document;
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new UrlConnectingError();
		}
		return document;
	}
}
