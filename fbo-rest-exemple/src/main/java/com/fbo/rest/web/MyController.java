package com.fbo.rest.web;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbo.rest.domain.Person;
import com.fbo.rest.service.PersonService;

/**
 * @author Fahd BOUDALI
 *
 */
@RestController
@RequestMapping("/poeple")
public class MyController { 

	/**
	 * Default html
	 */

	@Autowired
	PersonService personService;

	/**
	 * @return
	 */
	@RequestMapping(method = GET)
	public List<Person> showAll() {

		final List<Person> persons = personService.showAll();
		return persons;

	}

	/**
	 * @param person
	 * @return
	 */
	@RequestMapping(method = POST)
	public Person createNew(final Person person) {

		return personService.createNew(person);

	}

	/**
	 * @param person
	 * @return
	 */
	@RequestMapping(method = PUT)
	public Person update(final Person person) {

		return personService.update(person);

	}

	/**
	 * @param person
	 */
	@RequestMapping(method = DELETE)
	public void removePerson(final Person person) {

		personService.removePerson(person);

	}

}
