package com.andre.subscriptions.api.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.subscription.entities.Subscriber;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionController {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("subscribe")
	public Subscriber subscribe(@RequestBody Subscriber subscriber) {
		rabbitTemplate.convertAndSend("subscriptions.subscribe", subscriber);
		
		return subscriber;
	}
}
