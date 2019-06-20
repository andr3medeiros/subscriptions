package com.andre.subscription.email.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.andre.subscription.config.Constants;
import com.andre.subscription.entities.Subscriber;
import com.andre.subscription.services.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
	@Autowired
	private MailService mailService;
	@Autowired
	private ObjectMapper mapper;

    @KafkaListener(topics = Constants.KAFKA_SUBSCRIPTION_EMAIL_TOPIC, groupId = Constants.KAFKA_GROUP)
    public void consume(String message) throws IOException {
        log.info(String.format("#### -> New subscription! Sending emails... -> %s", message));
        
        Subscriber subscriber = mapper.readValue(message, Subscriber.class);
		mailService.sendEmail(subscriber);
    }
}