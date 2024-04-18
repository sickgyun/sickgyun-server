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
			setRecipientsAndFrom(coffeeChat, message);
			message.setSubject(setSubjectWithCoffeeChat(coffeeChat));
			message.setText(setContext(coffeeChat), "utf-8", "html");
		} catch (MessagingException e) {
			throw new EmailNotExistException();
		}

		mailSender.send(message);
	}

	private void setRecipientsAndFrom(CoffeeChat coffeeChat, MimeMessage message) throws MessagingException {
		if (coffeeChat.getState().equals(State.PENDING)) {
			message.addRecipients(TO, coffeeChat.getToUser().getEmail());
			message.setFrom(coffeeChat.getFromUser().getEmail());
		} else {
			message.addRecipients(TO, coffeeChat.getFromUser().getEmail());
			message.setFrom(coffeeChat.getToUser().getEmail());
		}
	}

	private String setSubjectWithCoffeeChat(CoffeeChat coffeeChat) {
		String fromUserName = coffeeChat.getFromUser().getName();
		String toUserName = coffeeChat.getToUser().getName();

		if (coffeeChat.getState() == State.ACCEPT) {
			return toUserName + "님께서 " + fromUserName + "님의 커피챗 요청을 수락하셨어요.";
		} else if (coffeeChat.getState() == State.REJECT) {
			return toUserName + "님께서 " + fromUserName + "님의 커피챗 요청을 거절하셨어요...ㅠ";
		}
		return fromUserName + "님으로부터 커피챗 요청이 왔어요.";
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
