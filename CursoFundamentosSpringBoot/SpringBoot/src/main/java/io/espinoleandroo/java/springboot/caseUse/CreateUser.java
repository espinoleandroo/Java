package io.espinoleandroo.java.springboot.caseUse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import io.espinoleandroo.java.springboot.entity.User;
import io.espinoleandroo.java.springboot.service.UserService;

@Component
public class CreateUser {

	private UserService userService;
	
	public CreateUser(UserService userService) {
		this.userService = userService;
	}

	public User save(User newUser) {
		return userService.save(newUser);
	}
}
