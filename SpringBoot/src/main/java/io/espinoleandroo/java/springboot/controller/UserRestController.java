package io.espinoleandroo.java.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.espinoleandroo.java.springboot.caseUse.GetUser;
import io.espinoleandroo.java.springboot.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	private GetUser getUser;
	
	public UserRestController(GetUser getUser) {
		this.getUser = getUser;
	}
	
	@GetMapping("/")
	List<User> get(){
		return getUser.getAll();
	}
}
