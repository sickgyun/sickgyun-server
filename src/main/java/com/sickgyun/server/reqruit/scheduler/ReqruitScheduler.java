package com.sickgyun.server.reqruit.scheduler;

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

import com.sickgyun.server.reqruit.domain.Reqruit;
import com.sickgyun.server.reqruit.exception.UrlConnectingError;
import com.sickgyun.server.reqruit.service.implementation.ReqruitCreator;
import com.sickgyun.server.reqruit.service.implementation.ReqruitDeleter;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReqruitScheduler {
	@Value("${reqruit.url}")
	private String url;
	private final ReqruitCreator reqruitCreator;
	private final ReqruitDeleter reqruitDeleter;

	@Scheduled(cron = "0 0 5 * * ?") // 매일 오전 5시
	public void getReqruitInformation() {
		System.out.println("asdfkjaslkfjakslfjdaskl");
		Document document = connectToServer();
		Elements rawReqruits = getReqruit(document);
		reqruitDeleter.deleteAll();
		reqruitCreator.createAll(getAllReqruits(rawReqruits));
	}

	private static List<Reqruit> getAllReqruits(Elements rawReqruits) {
		List<Reqruit> reqruit = new ArrayList<>();

		for (Element rawReqruit : rawReqruits) {
			String imageSrc = rawReqruit.selectFirst("img").attr("src");
			String company = rawReqruit.getElementsByClass("summary__company-name css-x5ccem").text();
			String name = rawReqruit.getElementsByClass("summary__title css-5g43jj").text();
			String stack = rawReqruit.getElementsByClass("css-1py9sy3").text();

			reqruit.add(
				new Reqruit(
					company,
					imageSrc,
					name,
					stack
				)
			);
		}
		return reqruit;
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
