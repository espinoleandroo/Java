package io.espinoleandroo.java.springboot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.espinoleandroo.java.springboot.bean.MyBeanWithProperties;
import io.espinoleandroo.java.springboot.bean.MyBeanWithPropertiesImplement;

@Configuration
public class GeneralConfiguration {
	@Value("${value.nombre}")
	private String nombre;

	@Value("${value.apellido}")
	private String apellido;
	
	@Value("${value.random}")
	private String random;
	
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(nombre, apellido);
	}
}
