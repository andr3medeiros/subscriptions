package com.andre.subscriptions.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.andre.subscription.config.SubscriptionsConfig;

@SpringBootApplication
@EnableConfigurationProperties(value = SubscriptionsConfig.class)
public class SubscriptionsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionsApiApplication.class, args);
	}

}
