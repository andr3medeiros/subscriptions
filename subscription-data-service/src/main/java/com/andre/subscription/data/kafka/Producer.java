package com.andre.subscription.data.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.andre.subscription.config.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendSavedSubscriptionMessage(String message) {
        log.info(String.format("#### -> New Subcription! -> %s", message));
        this.kafkaTemplate.send(Constants.KAFKA_SUBSCRIPTION_SAVED_TOPIC, message);
    }
}