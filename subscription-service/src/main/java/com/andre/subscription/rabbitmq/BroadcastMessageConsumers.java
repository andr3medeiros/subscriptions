package com.andre.subscription.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BroadcastMessageConsumers {

	@RabbitListener(queues = "${app.subscrition.subscription-queue-name}")
	public void receiveMessageFromTopic1(String message) {
		log.info(message);
	}

	@RabbitListener(queues = "${app.subscrition.unsubscription-queue-name}")
	public void receiveMessageFromTopic2(String message) {
		log.info(message);
	}

}
