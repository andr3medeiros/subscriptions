package com.andre.subscription.email.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.andre.subscription.config.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendSubscriptionMessage(String message) {
        log.info(String.format("#### -> New Subcription! -> %s", message));
        this.kafkaTemplate.send(Constants.KAFKA_SUBSCRIPTIONS_TOPIC, message);
    }
    
    public void sendUnSubscriptionMessage(String message) {
        log.info(String.format("#### -> New UnSubcription :( -> %s", message));
        this.kafkaTemplate.send(Constants.KAFKA_UNSUBSCRIPTIONS_TOPIC, message);
    }
}