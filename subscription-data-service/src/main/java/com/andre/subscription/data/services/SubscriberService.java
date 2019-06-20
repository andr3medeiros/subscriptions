package com.andre.subscription.data.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.andre.subscription.entities.Subscriber;

public interface SubscriberService {

	public Page<Subscriber> listAll(Pageable pageable);
	public Optional<Subscriber> findById(Integer id);
	public Optional<Subscriber> findByEmail(String email);
	public Subscriber save(Subscriber subscriber);
	public void delete(Integer id);
}
