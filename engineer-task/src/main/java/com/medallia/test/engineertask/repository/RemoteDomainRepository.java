package com.medallia.test.engineertask.repository;

import java.util.List;

import com.medallia.test.engineertask.model.Domain;

public interface RemoteDomainRepository {

	public List<Domain> findAll();

	public Domain save(Domain domain);

	public Domain findById(Long id);

	public void delete(Domain domain);
	
}
