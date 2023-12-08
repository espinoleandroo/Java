package io.espinoleandroo.java.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.espinoleandroo.java.springboot.web.app.models.User;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${text.indexcontroller.index.title}")
	private String textIndex;
	@Value("${text.indexcontroller.profile.title}")
	private String textProfile;
	@Value("${text.indexcontroller.list.title}")
	private String textList;

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {

		model.addAttribute("title", textIndex);

		return "index";
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("title", textProfile);
		
		User user = new User();
		user.setFirstName("Leandro");
		user.setLastName("Espino");
		user.setEmail("espinoleandroo@gmail.com");

		model.addAttribute("user", user);
		
		return "profile";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", textList);
		
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
