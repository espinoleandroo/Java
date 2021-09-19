package io.espinoleandroo.java.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.espinoleandroo.java.springboot.bean.MyBean;
import io.espinoleandroo.java.springboot.bean.MyBean2Implement;
import io.espinoleandroo.java.springboot.bean.MyBeanImplement;

@Configuration
public class MyConfigurationBean {

	@Bean
	public MyBean beanOperation() {
		return new MyBean2Implement();
	}
}
