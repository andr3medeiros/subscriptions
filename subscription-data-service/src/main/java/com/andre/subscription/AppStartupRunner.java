package com.andre.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;

import com.andre.subscription.config.Constants;

import lombok.extern.slf4j.Slf4j;

// @Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	kafkaTemplate.send(Constants.KAFKA_SUBSCRIPTION_SAVED_TOPIC, "testing 1!");
    	kafkaTemplate.send(Constants.KAFKA_SUBSCRIPTION_SAVED_TOPIC, "testing 2!");
    	
    	log.debug(kafkaTemplate.metrics().toString());
    }
}