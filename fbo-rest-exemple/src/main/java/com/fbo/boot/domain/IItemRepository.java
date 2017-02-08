package com.fbo.boot.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Fahd BOUDALI
 *
 */
@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface IItemRepository extends CrudRepository<Item, Long> {

	// empty
}