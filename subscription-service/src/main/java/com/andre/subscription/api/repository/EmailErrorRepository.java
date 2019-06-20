package com.andre.subscription.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.andre.subscription.entities.EmailError;

public interface EmailErrorRepository extends PagingAndSortingRepository<EmailError, Integer> {
}
