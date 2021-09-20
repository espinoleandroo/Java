package io.espinoleandroo.java.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.espinoleandroo.java.springboot.bean.MyBeanWithProperties;
import io.espinoleandroo.java.springboot.bean.MyBeanWithPropertiesImplement;
import io.espinoleandroo.java.springboot.dao.User;

@Configuration
@EnableConfigurationProperties(User.class)
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
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.username("SA");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}
}
