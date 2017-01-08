package com.fbo.ig2i.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbo.ig2i.entity.Person;
import com.fbo.ig2i.repo.PersonRepository;

/**
 * @author Fahd BOUDALI
 *
 * @see @RestController <br/>
 *      to return json
 */
@RestController
@RequestMapping("/poeple")
public class MyController {

	/**
	 * Default html
	 */

	@Autowired
	PersonRepository personRepo;

	@RequestMapping(method = GET)
	public List<Person> showAll() {

		List<Person> persons = (List<Person>) personRepo.findAll();
		return persons;

	}

	@RequestMapping(method = POST)
	public Person createNew(Person person) {

		return personRepo.save(person);

	}
	

	@RequestMapping(method = PUT)
	public Person update(Person person) {

		return personRepo.save(person);

	}
	

	@RequestMapping(method = DELETE)
	public void removePerson(Person person) {

		personRepo.delete(person);

	}

}
