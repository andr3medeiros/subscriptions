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
import com.andre.subscription.pojo.Subscription;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Service
public class MailService {
	@Autowired
    public JavaMailSender emailSender;

	private String processTemplate(Subscription subscription, String templateName) throws IOException {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache m = mf.compile(templateName);

		String html;
		try(StringWriter writer = new StringWriter()) {
			m.execute(writer, subscription).flush();
			
			html = writer.toString();
		}
		
		return html;
	}
	
	public void sendEmail(Subscriber subscriber) throws IOException, MessagingException {
		Subscription subscription = new Subscription(subscriber);
		String body = processTemplate(subscription, "subscription.mustache");
		
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		
		mimeMessage.setContent(body, "text/html");
		mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(subscriber.getEmail()));
		mimeMessage.setSubject("Thanks for subscribing!");
        
        emailSender.send(mimeMessage);
	}
}
