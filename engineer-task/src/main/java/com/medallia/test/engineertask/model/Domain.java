package com.medallia.test.engineertask.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table
public class Domain {

	@Id
	@GeneratedValue
	private Long domainId;
	
	@NonNull
	private String domain;
	
	@OneToMany(mappedBy = "domain")
	//@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Image> images; //= new ArrayList<Order>();
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp lastModified;
	
}
