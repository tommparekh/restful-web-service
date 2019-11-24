package com.cognizant.course.springrest.restfulwebservice.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	@Size(min = 2, message = "Name MUST have atleast 2 chars.")
	private String name;
	
	private Integer id;
	
	@Past (message = "Birthdate MUST be the past date.")
	private Date birthDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		/*
		 * return "User [name=" + name + ", id=" + id + ", birthDate=" + birthDate +
		 * ", getName()=" + getName() + ", getId()=" + getId() + ", getBirthDate()=" +
		 * getBirthDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
		 * + ", toString()=" + super.toString() + "]";
		 */
		
		return "User [name=" + name + ", id=" + id + ", birthDate=" + birthDate + ", getName()=" + getName()
		+ ", getId()=" + getId() + ", getBirthDate()=" + getBirthDate() + "]";
	}

	protected User() {
		super();
	}
	
	public User(String name, Integer id, Date birthDate) {
		super();
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
	}

}
