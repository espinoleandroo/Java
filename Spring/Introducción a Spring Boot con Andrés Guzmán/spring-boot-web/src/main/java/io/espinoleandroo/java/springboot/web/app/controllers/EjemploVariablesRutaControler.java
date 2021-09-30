package io.espinoleandroo.java.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaControler {

	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text, Model model) {
		model.addAttribute("title", "Recive params from route");
		model.addAttribute("textToShow", "The text sent to the route is: " + text);
		
		return "variables/see";
	}

	@GetMapping("/string/{text}/{number}")
	public String variables(@PathVariable String text,@PathVariable Integer number, Model model) {
		model.addAttribute("title", "Recive params from route");
		model.addAttribute("textToShow", "The text sent to the route is: " + text + " and the number is: " + number);
		
		return "variables/see";
	}
}
