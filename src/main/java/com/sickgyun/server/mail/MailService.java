package com.sickgyun.server.mail;

import static jakarta.mail.Message.RecipientType.*;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.sickgyun.server.coffeechat.domain.CoffeeChat;
import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.mail.exception.EmailNotExistException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender mailSender;
	private final SpringTemplateEngine templateEngine;

	@Async
	public void sendMail(CoffeeChat coffeeChat) {
		MimeMessage message = mailSender.createMimeMessage();

		try {
			message.addRecipients(TO, coffeeChat.getToUser().getEmail());
			message.setSubject("안녕하세요. 식견입니다.");
			message.setText(setContext(coffeeChat), "utf-8", "html");

			message.setFrom(coffeeChat.getFromUser().getEmail());
		} catch (MessagingException e) {
			throw new EmailNotExistException();
		}

		mailSender.send(message);
	}

	private String setContext(CoffeeChat coffeeChat) {
		Context context = new Context();
		context.setVariable("fromuser", coffeeChat.getFromUser().getName());
		context.setVariable("touser", coffeeChat.getToUser().getName());
		context.setVariable("message", coffeeChat.getMessage());
		return checkState(coffeeChat.getState(), context);
	}

	private String checkState(State type, Context context) {
		if (type.equals(State.ACCEPT)) {
			return templateEngine.process("accept-mail", context);
		} else if (type.equals(State.REJECT)) {
			return templateEngine.process("reject-mail", context);
		}
		return templateEngine.process("application-mail", context);
	}

}
