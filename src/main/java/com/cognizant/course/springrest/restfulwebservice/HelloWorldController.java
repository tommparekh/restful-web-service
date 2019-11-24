package com.cognizant.course.springrest.restfulwebservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@GetMapping(path="/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean !!! ");
	}
	
	//helloworld/path-variable/mihir
	@GetMapping(path="/helloworld/path-variable/{name}")
	public HelloWorldBean helloWorldBeanUsingPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Bean using Path Variable, %s !!", name));
	}

}
