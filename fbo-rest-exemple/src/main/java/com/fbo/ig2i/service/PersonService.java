/**
 * 
 */
package com.fbo.ig2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbo.ig2i.domain.Person;
import com.fbo.ig2i.domain.PersonRepository;

/**
 * @author FBO
 *
 */
@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;

	/**
	 * @return
	 */
	public List<Person> showAll() {

		return (List<Person>) personRepo.findAll();

	}

	/**
	 * @param person
	 * @return
	 */
	public Person createNew(Person person) {

		return personRepo.save(person);

	}
	

	/**
	 * @param person
	 * @return
	 */
	public Person update(Person person) {

		return personRepo.save(person);

	}
	

	/**
	 * @param person
	 */
	public void removePerson(Person person) {

		personRepo.delete(person);

	}
}
