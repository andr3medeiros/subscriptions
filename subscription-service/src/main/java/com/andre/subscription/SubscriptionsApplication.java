package com.andre.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.andre.subscription.config.SubscriptionsConfig;

@SpringBootApplication
@EnableConfigurationProperties(SubscriptionsConfig.class)
public class SubscriptionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionsApplication.class, args);
	}

}
