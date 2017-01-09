/**
 * 
 */
package com.fbo.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbo.rest.domain.Person;
import com.fbo.rest.domain.PersonRepository;

/**
 * @author FBO
 *
 */
@Service
public class PersonService {
 
	private final PersonRepository personRepo;

	/**
	 * @param personRepo
	 */
	@Autowired
	public PersonService(final PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}

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
	public Person createNew(final Person person) {

		return personRepo.save(person);

	}

	/**
	 * @param person
	 * @return
	 */
	public Person update(final Person person) {

		return personRepo.save(person);

	}

	/**
	 * @param person
	 */
	public void removePerson(final Person person) {

		personRepo.delete(person);

	}
}
