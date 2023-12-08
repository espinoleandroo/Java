package io.espinoleandroo.java.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String text, @RequestParam Integer number, Model model) {
		model.addAttribute("title", "Example Recive many params from URL");
		model.addAttribute("textToShow", "The text recived was ".concat(text) + " and the number is " + number);
		
		return "params/see";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		model.addAttribute("title", "Example Recive many params from URL");
		
		String text = request.getParameter("text");
		Integer number = 0;
		try {
			number = Integer.parseInt(request.getParameter("number"));
		} catch (Exception e) {
			;
		}
		model.addAttribute("textToShow", "The text recived was ".concat(text) + " and the number is " + number);
		
		return "params/see";
	}
}
 