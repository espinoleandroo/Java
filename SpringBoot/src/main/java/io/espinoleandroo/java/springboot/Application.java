package io.espinoleandroo.java.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.espinoleandroo.java.springboot.component.ComponentDependency;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private ComponentDependency componentDependency;
	
	public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		componentDependency.saludar();
		
	}

}
