package com.andre.subscription.email.kafka;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.andre.subscription.config.Constants;
import com.andre.subscription.entities.EmailError;
import com.andre.subscription.entities.Subscriber;
import com.andre.subscription.services.MailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
	@Autowired
	private MailService mailService;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private Producer producer;

    @KafkaListener(topics = Constants.KAFKA_SUBSCRIPTION_EMAIL_TOPIC, groupId = Constants.KAFKA_GROUP)
    public void consume(String message) throws JsonProcessingException {
        log.info(String.format("#### -> New subscription! Sending emails... -> %s", message));
        
        Subscriber subscriber = null; 
        try {
        	subscriber = mapper.readValue(message, Subscriber.class);
			mailService.sendEmail(subscriber);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			EmailError emailError = new EmailError();
			if(subscriber != null) {
				emailError.setEmail(subscriber.getEmail());
			}
			emailError.setError(e.getMessage());
			emailError.setDate(new Date());
			
			String json = mapper.writeValueAsString(emailError);
			
			producer.sendEmailErrorMessage(json);
		}
    }
}