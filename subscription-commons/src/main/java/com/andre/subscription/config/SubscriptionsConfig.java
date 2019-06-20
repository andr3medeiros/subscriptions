package com.andre.subscription.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("app.subscription")
public class SubscriptionsConfig {
	private String subscriptionQueueName;
	private String unsubscriptionQueueName;
	private String exchangeName;
}
