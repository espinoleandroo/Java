package io.espinoleandroo.java.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.espinoleandroo.java.springboot.bean.MyBean;
import io.espinoleandroo.java.springboot.component.ComponentDependency;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private ComponentDependency componentDependency;
	private MyBean myBean;
	
	public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		componentDependency.saludar();
		myBean.print();
	}

}
