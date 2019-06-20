package com.andre.subscription.data.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.andre.subscription.data.repository.SubscriptionRepository;
import com.andre.subscription.data.services.SubscriberService;
import com.andre.subscription.entities.Subscriber;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private SubscriptionRepository repository;

	@Override
	public Page<Subscriber> listAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Subscriber> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Subscriber> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Subscriber save(Subscriber subscriber) {
		return repository.save(subscriber);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
