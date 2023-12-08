package io.espinoleandroo.java.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.espinoleandroo.java.springboot.caseUse.GetUser;
import io.espinoleandroo.java.springboot.caseUse.GetUserImplement;
import io.espinoleandroo.java.springboot.service.UserService;

@Configuration
public class CaseUseConfiguration {

	@Bean
	GetUser getUser(UserService userService) {
		return new GetUserImplement(userService);
	}
}
