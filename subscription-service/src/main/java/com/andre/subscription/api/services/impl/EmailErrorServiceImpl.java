package com.andre.subscription.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.andre.subscription.api.repository.EmailErrorRepository;
import com.andre.subscription.api.services.EmailErrorService;
import com.andre.subscription.entities.EmailError;

@Service
public class EmailErrorServiceImpl implements EmailErrorService {
	@Autowired
	private EmailErrorRepository repository;

	@Override
	public Page<EmailError> listAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<EmailError> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public EmailError save(EmailError emailError) {
		return repository.save(emailError);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}