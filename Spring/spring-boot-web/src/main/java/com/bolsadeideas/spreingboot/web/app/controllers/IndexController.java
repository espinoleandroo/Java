package com.bolsadeideas.spreingboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.spreingboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {

		model.addAttribute("title", "Hello Spring Framework");

		return "index";
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("title", "User Profile");
		
		User user = new User();
		user.setFirstName("Leandro");
		user.setLastName("Espino");
		user.setEmail("espinoleandroo@gmail.com");

		model.addAttribute("user", user);
		
		return "profile";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", "Users List");
		
		return "list";
	}

	@ModelAttribute("users")
	public List<User> createUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User("Leandro", "Espino", "espinoleandroo@gmail.com"));
		users.add(new User("Itzel", "Ruiz", "itzelgarciaruiz@gmail.com"));
		return users;
	}
	
}
