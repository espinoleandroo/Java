package io.espinoleandroo.java.springboot.caseUse;

import org.springframework.stereotype.Component;

import io.espinoleandroo.java.springboot.entity.User;
import io.espinoleandroo.java.springboot.service.UserService;

@Component
public class UpdateUser {

	private UserService userService;
	
	public UpdateUser(UserService userService) {
		this.userService = userService;
	}

	public User update(User newUser, Long id) {
		return userService.updateUser(newUser, id);
	}
}
