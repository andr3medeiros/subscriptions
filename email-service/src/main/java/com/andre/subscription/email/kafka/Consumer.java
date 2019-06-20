package com.andre.subscription.email.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.andre.subscription.config.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = Constants.KAFKA_SUBSCRIPTION_SAVED_TOPIC, groupId = Constants.KAFKA_GROUP)
    public void consume(String message) throws IOException {
        log.info(String.format("#### -> New subscription! Sending emails... -> %s", message));
    }
}