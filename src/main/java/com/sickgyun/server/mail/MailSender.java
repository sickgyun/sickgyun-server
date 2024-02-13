package com.sickgyun.server.mail;

import static jakarta.mail.Message.RecipientType.*;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.sickgyun.server.coffeechat.domain.value.State;
import com.sickgyun.server.mail.exception.EmailNotExistException;
import com.sickgyun.server.user.domain.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailSender {

	private final JavaMailSender mailSender;
	private final SpringTemplateEngine templateEngine;

	public void sendMail(User fromUser, User toUser, State type) {
		MimeMessage message = mailSender.createMimeMessage();

		try {
			message.addRecipients(TO, toUser.getEmail());
			message.setSubject("안녕하세요. 식견입니다.");
			message.setText(setContext(fromUser, toUser, type), "utf-8", "html");
		} catch (MessagingException e) {
			throw new EmailNotExistException();
		}

		mailSender.send(message);
	}

	private String setContext(User fromUser, User toUser, State type) {
		Context context = new Context();
		context.setVariable("fromuser", fromUser.getName());
		context.setVariable("touser", toUser.getName());
		return checkType(type, context);
	}

	private String checkType(State type, Context context) {
		if (type.equals(State.ACCEPT)) {
			return templateEngine.process("accept-mail", context);
		} else if (type.equals(State.REJECT)) {
			return templateEngine.process("reject-mail", context);
		} else if (type.equals(State.TIME)) {
			return templateEngine.process("time-mail", context);
		}
		return templateEngine.process("application-mail", context);
	}

}
