package com.andre.subscription.services;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
		Mustache m = mf.compile("todo.mustache");

		String html;
		try(StringWriter writer = new StringWriter()) {
			m.execute(writer, subscriber).flush();
			
			html = writer.toString();
		}
		
		return html;
	}
	
	public void sendEmail(Subscriber subscriber) throws IOException {
		String body = processTemplate(subscriber, "subscription.mustache");
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(subscriber.getEmail()); 
        message.setSubject("Tanks for subscribing!"); 
        message.setText(body);
        
        emailSender.send(message);
	}
}
