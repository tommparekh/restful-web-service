package com.cognizant.course.springrest.restfulwebservice.helloworld;

public class HelloWorldBean {
	private String name;
	
	

	public HelloWorldBean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [name=" + name + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
