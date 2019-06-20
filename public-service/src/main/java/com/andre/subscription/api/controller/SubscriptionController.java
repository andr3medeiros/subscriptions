package com.andre.subscription.api.controller;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.andre.subscription.api.kafka.Producer;
import com.andre.subscription.entities.Subscriber;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/subscriptions")
@Slf4j
public class SubscriptionController {
	@Autowired
	private Producer kafkaProducer;
	@Autowired
	private ObjectMapper mapper;

	@PostMapping("subscribe")
	public DeferredResult<Integer> subscribe(@RequestBody Subscriber subscriber) throws JsonProcessingException {
		final int newsletterId = RandomUtils.nextInt(999999) + 1;
		subscriber.setNewsletterId(newsletterId);
		
		final DeferredResult<Integer> deferredResult = new DeferredResult<>();

		String toJson = mapper.writeValueAsString(subscriber);
		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaProducer.sendSubscriptionMessage(toJson);

		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				deferredResult.setResult(newsletterId);
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error(ex.getMessage());
				deferredResult.setErrorResult(ex);
			}
		});

		return deferredResult;
	}
	
	@GetMapping("unsubscribe")
	public DeferredResult<String> unsubscribe(@RequestParam("email") String email) {
		final DeferredResult<String> deferredResult = new DeferredResult<>();

		ListenableFuture<SendResult<String, String>> listenableFuture = kafkaProducer.sendUnSubscriptionMessage(email);

		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				deferredResult.setResult("Sorry for the inconvenience!");
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error(ex.getMessage());
				deferredResult.setErrorResult(ex);
			}
		});

		return deferredResult;
	}
}
