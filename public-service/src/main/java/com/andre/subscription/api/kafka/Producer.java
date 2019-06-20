package com.andre.subscription.api.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.andre.subscription.config.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public ListenableFuture<SendResult<String, String>> sendSubscriptionMessage(String message) {
        log.info(String.format("#### -> New Subcription! -> %s", message));
        return kafkaTemplate.send(Constants.KAFKA_SUBSCRIPTIONS_TOPIC, message);
    }
    
    public ListenableFuture<SendResult<String, String>> sendUnSubscriptionMessage(String message) {
        log.info(String.format("#### -> New UnSubcription :( -> %s", message));
        return kafkaTemplate.send(Constants.KAFKA_UNSUBSCRIPTIONS_TOPIC, message);
    }
}