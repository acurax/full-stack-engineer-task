package com.medallia.test.engineertask.ws.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medallia.test.engineertask.model.Domain;
import com.medallia.test.engineertask.model.DomainDatabase;
import com.medallia.test.engineertask.model.UserDatabase;
import com.medallia.test.engineertask.service.ApiConsumptionService;
import com.medallia.test.engineertask.service.DomainService;

import lombok.extern.log4j.Log4j2;

/*
 * MyTestRestController.class
 * 
 * @Author Jorge Hernandez
 * @Description
 * 
 * This is my Rest Controller to test different components of the Rest-APP via RESTFul
 * 
 * */

@Log4j2
@RestController
@RequestMapping("/api/v1/test")
public class MyTestRestController {
	
	ApiConsumptionService apiConsumptionService;
	
    public MyTestRestController(ApiConsumptionService apiConsumptionService) {
        this.apiConsumptionService = apiConsumptionService;
    }
	
    @GetMapping(value = "/test-coms-getdbfordomain/{domain}")
    public ResponseEntity<DomainDatabase> testConsumGetDBForDomainApi(@PathVariable String domain) {
    	
    	try {
    		return new ResponseEntity<>(apiConsumptionService.findDomainDatabaseById(domain), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity("Test test-coms-getdbfordomain Exception encountered", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
        
    } 
    
    @GetMapping(value = "/test-coms-getdatabases")
    public ResponseEntity<List<UserDatabase>> testConsumgetDatabasesApi() {
    	
    	try {
    		return new ResponseEntity<>(apiConsumptionService.getDatabases(), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity("Test test-coms-getdatabases Exception encountered", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
        
    } 
    
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        
        return new ResponseEntity("Test Rest request successfully", HttpStatus.OK);
    }

}
