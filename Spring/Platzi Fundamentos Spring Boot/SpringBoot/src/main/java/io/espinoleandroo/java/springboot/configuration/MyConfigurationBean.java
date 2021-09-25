package io.espinoleandroo.java.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.espinoleandroo.java.springboot.bean.MyBean;
import io.espinoleandroo.java.springboot.bean.MyBean2Implement;
import io.espinoleandroo.java.springboot.bean.MyBeanImplement;
import io.espinoleandroo.java.springboot.bean.MyBeanWithDependency;
import io.espinoleandroo.java.springboot.bean.MyBeanWithDependencyImplement;
import io.espinoleandroo.java.springboot.bean.MyOperation;
import io.espinoleandroo.java.springboot.bean.MyOperationImplement;

@Configuration
public class MyConfigurationBean {

	@Bean
	public MyBean beanOperation() {
		return new MyBean2Implement();
	}
	
	@Bean
	public MyOperation beanOperationOperation() {
		return new MyOperationImplement();
	}
	
	@Bean
	public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation) {
		return new MyBeanWithDependencyImplement(myOperation);
	}
	
}
