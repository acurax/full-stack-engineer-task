package com.medallia.test.engineertask.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Image {

	@Id
	@GeneratedValue
	private Long imageId;
	private String url;
	
	@ManyToOne
    @JoinColumn(name="domainId", referencedColumnName = "domainId")
	@JsonIgnore
    private Domain domain;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp lastModified;
	
}
