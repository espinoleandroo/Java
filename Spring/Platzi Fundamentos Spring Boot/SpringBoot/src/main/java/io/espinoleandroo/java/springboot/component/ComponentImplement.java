package io.espinoleandroo.java.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

	@Override
	public void saludar() {
		System.out.println("Hola Mundo desde mi Component");
		
	}
	
}
