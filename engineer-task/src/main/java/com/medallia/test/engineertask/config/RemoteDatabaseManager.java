package com.medallia.test.engineertask.config;

import java.util.List;

import com.medallia.test.engineertask.model.Domain;
import com.medallia.test.engineertask.model.UserDatabase;
import com.medallia.test.engineertask.repository.RemoteDomainRepository;

public interface RemoteDatabaseManager {
	
	public boolean isDatabaseAvailable(UserDatabase userDatabase);

	public RemoteDomainRepository getDatabaseRepository(UserDatabase userDatabase);

}
