package io.espinoleandroo.java.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import io.espinoleandroo.java.springboot.entity.User;
import io.espinoleandroo.java.springboot.repository.UserRepository;

@Service
public class UserService {
	private final Log LOG = LogFactory.getLog(UserService.class);
	private UserRepository userRepository;
	
	public UserService(UserRepository repository) {
		this.userRepository = repository;
	}
	
	@Transactional
	public void saveTransactional(List<User> users) {
		users.stream()
			.peek(user -> LOG.info("INSERT" + user))
			.forEach(userRepository::save);
	}
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
