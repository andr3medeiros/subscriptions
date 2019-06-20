package com.andre.subscription.services;

import java.io.IOException;
import java.io.StringWriter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.andre.subscription.entities.Subscriber;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Service
public class MailService {
	@Autowired
    public JavaMailSender emailSender;

	private String processTemplate(Subscriber subscriber, String templateName) throws IOException {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache m = mf.compile(templateName);

		String html;
		try(StringWriter writer = new StringWriter()) {
			m.execute(writer, subscriber).flush();
			
			html = writer.toString();
		}
		
		return html;
	}
	
	public void sendEmail(Subscriber subscriber) throws IOException, MessagingException {
		String body = processTemplate(subscriber, "subscription.mustache");
		
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		
		mimeMessage.setContent(body, "text/html");
		mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(subscriber.getEmail()));
		mimeMessage.setSubject("Tanks for subscribing!");
        
        emailSender.send(mimeMessage);
	}
}
