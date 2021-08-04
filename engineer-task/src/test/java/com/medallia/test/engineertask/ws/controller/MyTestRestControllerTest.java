package com.medallia.test.engineertask.ws.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.medallia.test.engineertask.model.DomainDatabase;
import com.medallia.test.engineertask.service.ApiConsumptionService;

class MyTestRestControllerTest {

	private ApiConsumptionService apiConsumptionService;
	
	private MyTestRestController myTestRestController;
	
	@BeforeEach
	void setUp() throws Exception {
		
		apiConsumptionService = Mockito.mock(ApiConsumptionService.class);
		myTestRestController = new MyTestRestController(apiConsumptionService);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testTestConsumGetDBForDomainApi() {
		
		when(apiConsumptionService.findDomainDatabaseById("google.com")).thenReturn(new DomainDatabase((long) 1, "google.com"));
		
		// case 1
		ResponseEntity<DomainDatabase> ResponseEntityDomainDatabase = myTestRestController.testConsumGetDBForDomainApi("google.com");
		DomainDatabase domainDatabase = ResponseEntityDomainDatabase.getBody();
		assertNotNull(domainDatabase);
		
		// case 2
		ResponseEntityDomainDatabase = myTestRestController.testConsumGetDBForDomainApi("nullDomainDatabase");
		domainDatabase = ResponseEntityDomainDatabase.getBody();
		assertNull(domainDatabase);
		
	}

	//@Test
	void testTestConsumgetDatabasesApi() {
		fail("Not yet implemented");
		
	}

	@Test
	void testTest() {
		
		ResponseEntity<?> responseEntity = myTestRestController.test();
		
		assertEquals(responseEntity, new ResponseEntity("Test Rest request successfully", HttpStatus.OK));
		
	}

}
