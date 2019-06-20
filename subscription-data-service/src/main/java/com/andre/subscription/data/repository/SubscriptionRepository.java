package com.andre.subscription.data.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.andre.subscription.entities.Subscriber;

public interface SubscriptionRepository extends PagingAndSortingRepository<Subscriber, Integer> {
	
	Optional<Subscriber> findByEmail(String email);
}
