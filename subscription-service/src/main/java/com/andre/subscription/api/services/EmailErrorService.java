package com.andre.subscription.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.andre.subscription.entities.EmailError;

public interface EmailErrorService {

	public Page<EmailError> listAll(Pageable pageable);
	public Optional<EmailError> findById(Integer id);
	public EmailError save(EmailError emailError);
	public void delete(Integer id);
}
