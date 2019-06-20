package com.andre.subscriptions.api.rabbitmq;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Receiver;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.andre.subscription.config.SubscriptionsConfig;

public class RabbitMQConfig {
	@Autowired
	private SubscriptionsConfig subscriptionsConfig;
    
    @Bean
    public List<Declarable> topicBindings() {
        Queue topicQueue1 = new Queue(subscriptionsConfig.getSubscriptionQueueName(), false);
        Queue topicQueue2 = new Queue(subscriptionsConfig.getUnsubscriptionQueueName(), false);
     
        TopicExchange topicExchange = new TopicExchange(subscriptionsConfig.getExchangeName());
     
        return Arrays.asList(
          topicQueue1,
          topicQueue2,
          topicExchange,
          BindingBuilder
            .bind(topicQueue1)
            .to(topicExchange).with("*.subscribe"),
          BindingBuilder
            .bind(topicQueue2)
            .to(topicExchange).with("*.unsubscribe"));
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
