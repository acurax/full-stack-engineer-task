package com.medallia.test.engineertask.service;

import java.util.List;

import com.medallia.test.engineertask.model.UserDatabase;
import com.medallia.test.engineertask.model.DomainDatabase;

public interface ApiConsumptionService {
	
	public List<UserDatabase> getDatabases();

	public DomainDatabase findDomainDatabaseById(String domain);

}
