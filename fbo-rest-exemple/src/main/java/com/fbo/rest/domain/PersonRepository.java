package com.fbo.rest.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Fahd BOUDALI
 *
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<Person, Long> {

	/** 
	 * Find person by his/her name
	 * 
	 * @param name
	 * @return
	 */
	List<Person> findByLastName(@Param("name") String name);


}