package com.fbo.boot.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Fahd BOUDALI
 *
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface IUserRepository extends CrudRepository<User, Long> {

	/**
	 * Find person by his/her name
	 * 
	 * @param name
	 * @return
	 */
	List<User> findByLastName(@Param("name") String name);

	
	/**
	 * @return
	 */
	@Query("select u from User u where u.email=?#{principal.email}")
	User findCurrentUser();
	/**
	 * @param username
	 * @return
	 */
	User findByEmail(@Param("username") String username);

}