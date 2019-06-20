package com.andre.subscription.api.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andre.subscription.config.Constants;

@Configuration
public class KafkaTopicConfig {
    
	@Bean
    public NewTopic subscriptions() {
         return new NewTopic(Constants.KAFKA_SUBSCRIPTIONS_TOPIC, 1, (short) 1);
    }
    
    @Bean
    public NewTopic unSubscriptions() {
         return new NewTopic(Constants.KAFKA_UNSUBSCRIPTIONS_TOPIC, 1, (short) 1);
    }
}