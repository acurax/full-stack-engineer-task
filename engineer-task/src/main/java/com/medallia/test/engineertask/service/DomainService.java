package com.medallia.test.engineertask.service;

import java.util.List;
import java.util.Optional;

import com.medallia.test.engineertask.model.Domain;

public interface DomainService {
	
	public List<Domain> findAll();

	public Domain save(Domain domain);

	public Domain findById(Long id);

	public void delete(Domain domain);
	

}
