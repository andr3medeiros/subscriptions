package com.andre.subscription.data.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.andre.subscription.config.Constants;
import com.andre.subscription.data.services.SubscriberService;
import com.andre.subscription.entities.Subscriber;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
	@Autowired
	private SubscriberService service;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private Producer kafkaProducer;
	

    @KafkaListener(topics = Constants.KAFKA_SUBSCRIPTIONS_TOPIC, groupId = Constants.KAFKA_GROUP)
    public void consumeSubscriptions(String message) throws IOException {
        log.info(String.format("#### -> New subscription! -> %s", message));
        
        Subscriber subscriber = mapper.readValue(message, Subscriber.class);
        
        service.save(subscriber);
        
        kafkaProducer.sendSavedSubscriptionMessage(message);
    }
    
    @KafkaListener(topics = Constants.KAFKA_UNSUBSCRIPTIONS_TOPIC, groupId = Constants.KAFKA_GROUP)
    public void consumeUnsubscriptions(String message) throws IOException {
        log.info(String.format("#### -> New unsubscription :( -> %s", message));
        
        Subscriber subscriber = mapper.readValue(message, Subscriber.class);
        
        subscriber.setSubscribed(false);
        
        service.save(subscriber);
    }
}