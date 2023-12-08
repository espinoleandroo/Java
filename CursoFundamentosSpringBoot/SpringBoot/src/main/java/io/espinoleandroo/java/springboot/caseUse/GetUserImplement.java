package io.espinoleandroo.java.springboot.caseUse;

import java.util.List;

import io.espinoleandroo.java.springboot.entity.User;
import io.espinoleandroo.java.springboot.service.UserService;

public class GetUserImplement implements GetUser {

	private UserService userService;

	public GetUserImplement(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userService.getAllUsers();
	}

}
