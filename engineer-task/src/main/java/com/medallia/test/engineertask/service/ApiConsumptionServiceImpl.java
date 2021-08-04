package com.medallia.test.engineertask.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.medallia.test.engineertask.model.DomainDatabase;
import com.medallia.test.engineertask.model.UserDatabase;

@Service
public class ApiConsumptionServiceImpl implements ApiConsumptionService {

	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "http://localhost:8080/";
	
	@Override
	public DomainDatabase findDomainDatabaseById(String domain) {

		DomainDatabase domainDatabase = restTemplate.getForObject(url + "getDBForDomain/" + domain, DomainDatabase.class);
		
		return domainDatabase;
	}

	@Override
	public List<UserDatabase> getDatabases() {
		
		UserDatabase[] domainDatabases = restTemplate.getForObject(url + "getDatabases/", UserDatabase[].class);
		
		//List<UserDatabase> domainDatabases = restTemplate.getForObject(url + "getDatabases/", List<UserDatabase.class>.);
		
		return Arrays.asList(domainDatabases); 
		
	}
	
	
	

}
