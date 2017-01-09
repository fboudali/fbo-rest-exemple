/**
 * 
 */
package com.fbo.rest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Fahd BOUDALI
 *
 */
@Entity
public class Person {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;
	
	private Date lastUpdateDate;

	public Person() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public Person(final String firstName, final String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdateDate=new Date();
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(final Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


}
