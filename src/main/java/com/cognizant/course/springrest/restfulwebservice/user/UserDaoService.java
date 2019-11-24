package com.cognizant.course.springrest.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	public static int usersCount = 3;

	static {
		users.add(new User("Adam", 1, new Date()));
		users.add(new User("Eve", 2, new Date()));
		users.add(new User("Jack", 3, new Date()));
	}

	// public List<User> findAll()

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);

		return user;
	}

	public User findOne(int id) {
		users.forEach(System.out::println);

		User resultUser = users.stream().filter(u -> u.getId() == id).findAny().orElse(null);

		return resultUser;
	}

}
