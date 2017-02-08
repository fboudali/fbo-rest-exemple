package com.fbo.boot.domain;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Fahd BOUDALI
 *
 */
@Entity
public class Item implements Serializable {
	/** UID */
	private static final long serialVersionUID = -2746302661784035223L;


	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	private String description;

	public Long getId() {
	return id;
	}

	public void setId(final Long id) {
	this.id = id;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(final String description) {
	this.description = description;
	}

	 

}
