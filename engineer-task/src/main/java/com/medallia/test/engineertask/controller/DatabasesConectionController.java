package com.medallia.test.engineertask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.medallia.test.engineertask.config.RemoteDatabaseManager;
import com.medallia.test.engineertask.model.Domain;
import com.medallia.test.engineertask.model.DomainDatabase;
import com.medallia.test.engineertask.model.UserDatabase;
import com.medallia.test.engineertask.repository.RemoteDomainRepository;
import com.medallia.test.engineertask.service.ApiConsumptionService;
import com.medallia.test.engineertask.service.DomainService;

@Controller
public class DatabasesConectionController {
	
	@Autowired
	private DomainService domainService;
	
	@Autowired
	private RemoteDatabaseManager remoteDatabaseManager;
	
	@Autowired
	private ApiConsumptionService apiConsumptionService;
	
	public List<Domain> findAll() {
		
		return domainService.findAll();
		
	}

	public Domain save(Domain domain) {
		
		// Local save
		if (!checkDataBaseAvailability(domain)) {
			
			return domainService.save(domain);
		}
			
		// Remote Save
		domain = this.remoteSaveDomain(domain);
		
		return domain;
	}

	public Domain findById(Long id) {
		
		return domainService.findById(id);
	}

	public void delete(Domain domain) {
		
		domainService.delete(domain);
	}
	
	private boolean checkDataBaseAvailability(Domain domain) {
		
		DomainDatabase domainDatabase = apiConsumptionService.findDomainDatabaseById(domain.getDomain());
		
		if (domainDatabase != null) {
			
			List<UserDatabase> databases = apiConsumptionService.getDatabases();
			
			for (UserDatabase userDatabase : databases) {
				if (userDatabase.getId() == domainDatabase.getDbId()) {
					return remoteDatabaseManager.isDatabaseAvailable(userDatabase);
				}
			}
		}
		
		return false;
		
	}
	
	private Domain remoteSaveDomain(Domain domain) {
		
		
		DomainDatabase domainDatabase = apiConsumptionService.findDomainDatabaseById(domain.getDomain());
		
		if (domainDatabase != null) {
			
			List<UserDatabase> databases = apiConsumptionService.getDatabases();
			
			for (UserDatabase userDatabase : databases) {
				if (userDatabase.getId() == domainDatabase.getDbId() && remoteDatabaseManager.isDatabaseAvailable(userDatabase)) {
					
					RemoteDomainRepository databaseRepository = remoteDatabaseManager.getDatabaseRepository(userDatabase);
					
					return databaseRepository.save(domain);
				}
			}
		}

		
		return domain;
	}
	
}
