package com.medallia.test.engineertask.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medallia.test.engineertask.model.Domain;

@Repository
public interface DomainRepository extends CrudRepository<Domain, Long>  {
	

}
