package com.cognizant.course.springrest.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user = service.findOne(id);
		
		if (user == null) {
		
			throw new UserNotFoundException("ID - " + id);
		}		 
		
		return user;
	}

	// POST /users
	// input - details of the user
	// output - CREATED status and created URI

	@PostMapping("/users")
	public ResponseEntity<Object> createdUser(@RequestBody User user) {
		// System.out.println(String.format("###### User: %s", user.toString()));
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();

	}

}
