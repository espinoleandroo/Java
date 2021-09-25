package io.espinoleandroo.java.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.espinoleandroo.java.springboot.bean.MyBeanWithProperties;
import io.espinoleandroo.java.springboot.bean.MyBeanWithPropertiesImplement;
import io.espinoleandroo.java.springboot.dao.User;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(User.class)
public class GeneralConfiguration {
	@Value("${value.nombre}")
	private String nombre;

	@Value("${value.apellido}")
	private String apellido;
	
	@Value("${value.random}")
	private String random;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${driver}")
	private String driver;
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(nombre, apellido);
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(jdbcUrl);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
	}
}
