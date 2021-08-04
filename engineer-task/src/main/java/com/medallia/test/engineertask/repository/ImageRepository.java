package com.medallia.test.engineertask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medallia.test.engineertask.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

}
