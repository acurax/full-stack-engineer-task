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
import com.medallia.test.engineertask.model.Image;
import com.medallia.test.engineertask.model.UserDatabase;
import com.medallia.test.engineertask.service.ApiConsumptionService;
import com.medallia.test.engineertask.service.DomainService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@RequestMapping("/api/v1/domain")
public class DomainController {
	
	DomainService domainService;
	
	ApiConsumptionService apiConsumptionService;
	
    public DomainController(DomainService domainService, ApiConsumptionService apiConsumptionService) {
        this.domainService = domainService;
        this.apiConsumptionService = apiConsumptionService;
    }
	
	@GetMapping(value = "/")
    public ResponseEntity<List<Domain>> getAllDomains() {
    	
    	List<Domain> domains = domainService.findAll();
        return new ResponseEntity<>(domains, HttpStatus.OK);
    }

    @GetMapping(value = "/byId/{domainId}")
    public ResponseEntity<Domain> getDomainById(@PathVariable("domainId") Long domainId) {
    	
    	return new ResponseEntity<>(domainService.findById(domainId), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Domain> saveOrUpdateDomain(@RequestBody Domain domain) {
        
    	// is Update
    	if (domain.getDomainId() != null) {
    		
    		Domain initialDomain;
			try {
				initialDomain = domainService.findById(domain.getDomainId());
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return new ResponseEntity("Domain ID " + domain.getDomainId() + " Does not exist", HttpStatus.BAD_REQUEST);
			}
    		
    		if (initialDomain != null) {
    			
    			domainService.save(domain);
    			return new ResponseEntity<>(domainService.findById(domain.getDomainId()), HttpStatus.OK);
    		}
    		
    	}
    	
		Domain savedDomain = domainService.save(domain);
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/v1/domain" + savedDomain.getDomainId().toString());
        return new ResponseEntity<>(savedDomain, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{domainId}")
    public ResponseEntity<Domain> deleteDomainByName(@PathVariable Long  domainId) {
    	
        domainService.delete(domainService.findById(domainId));
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }

}
