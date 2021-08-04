package com.medallia.test.engineertask.config;

import org.springframework.stereotype.Service;

import com.medallia.test.engineertask.model.Domain;
import com.medallia.test.engineertask.model.UserDatabase;
import com.medallia.test.engineertask.repository.RemoteDomainRepository;

@Service
public class RemoteDatabaseManagerImpl implements RemoteDatabaseManager {

	@Override
	public boolean isDatabaseAvailable(UserDatabase userDatabase) {


		// Create a new instance of a configuration class and check the connection with that database
		
		// Return the result of the connection check
		
		return false;
	}

	@Override
	public RemoteDomainRepository getDatabaseRepository (UserDatabase userDatabase) {

		
		// Create a new instance of a configuration class and check the connection with that database
		
		// return the repository of the connection 
		
		return null;
	}

}
