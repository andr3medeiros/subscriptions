package com.andre.subscription.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.subscription.api.kafka.Producer;
import com.andre.subscription.entities.Subscriber;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionController {
	@Autowired
	private Producer kafkaProducer;
	@Autowired
	private ObjectMapper mapper;
	
	@PostMapping("subscribe")
	public Subscriber subscribe(@RequestBody Subscriber subscriber) throws JsonProcessingException {
		String toJson = mapper.writeValueAsString(subscriber);
		kafkaProducer.sendSubscriptionMessage(toJson);
		
		return subscriber;
	}
}
