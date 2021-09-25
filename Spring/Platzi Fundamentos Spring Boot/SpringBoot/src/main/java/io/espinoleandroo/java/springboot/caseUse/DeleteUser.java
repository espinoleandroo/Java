package io.espinoleandroo.java.springboot.caseUse;

import org.springframework.stereotype.Component;

import io.espinoleandroo.java.springboot.service.UserService;

@Component
public class DeleteUser {

	private UserService userService;
	
	public DeleteUser(UserService userService) {
		this.userService = userService;
	}

	public void remove(Long id) {
		userService.delete(id);
	}
}
