package com.medallia.test.engineertask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDatabase {

	private Long id;
	private String host;
	private String schema;
	
	// TODO: Look for a way to encrypt this password
	private String password;
	
}
