package com.medallia.test.engineertask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomainDatabase {

	private Long dbId;
	private String domain;
	
}
