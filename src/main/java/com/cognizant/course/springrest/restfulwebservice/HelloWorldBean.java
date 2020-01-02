package com.cognizant.course.springrest.restfulwebservice;

public class HelloWorldBean {
	
	private String message;
	
	public HelloWorldBean(String str) {
		message = str;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
