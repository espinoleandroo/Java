package com.bolsadeideas.spreingboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Example Send params from URL");
		
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "text", required = false, defaultValue = "default value") String text, Model model) {
		model.addAttribute("title", "Example Recive params from URL");
		model.addAttribute("textToShow", "The text recived was ".concat(text));
		
		return "params/see";
	}
}
 