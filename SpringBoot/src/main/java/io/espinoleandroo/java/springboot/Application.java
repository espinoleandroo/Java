package io.espinoleandroo.java.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.espinoleandroo.java.springboot.bean.MyBean;
import io.espinoleandroo.java.springboot.bean.MyBeanWithDependency;
import io.espinoleandroo.java.springboot.bean.MyBeanWithProperties;
import io.espinoleandroo.java.springboot.component.ComponentDependency;
import io.espinoleandroo.java.springboot.dao.User;

@SpringBootApplication
public class Application implements CommandLineRunner{

	Log LOGGER = LogFactory.getLog(Application.class);
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency beanWithDependency;
	private MyBeanWithProperties beanWithProperties;
	private User user;
	
	
	public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency beanWithDependency, MyBeanWithProperties beanWithProperties, User user) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependency = beanWithDependency;
		this.beanWithProperties = beanWithProperties;
		this.user = user;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		componentDependency.saludar();
		myBean.print();
		beanWithDependency.printWithDependency();
		System.out.println(beanWithProperties.function());
		System.out.println(user.getEmail() + " " + user.getPassword());
		try {
			int value = 10/0;
		} catch (Exception e) {
			LOGGER.error("ERROR: " + e.getMessage());
		}
		
	}

}
