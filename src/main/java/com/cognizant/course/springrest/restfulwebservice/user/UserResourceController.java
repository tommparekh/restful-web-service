package com.cognizant.course.springrest.restfulwebservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserDaoService service;

	// GET /users
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	// GET /users/{id}
	
	@GetMapping("/users/id/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	
	// POST /users
	// input - details of the user
	// output - CREATED status and created URI
	
	@PostMapping("/users")
	public void createdUser(@RequestBody User user) {
		System.out.println(String.format("###### User: %s", user.toString()));
		service.save(user);
		
		
	}
	
}
