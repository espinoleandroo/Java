package io.espinoleandroo.java.springboot;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import io.espinoleandroo.java.springboot.bean.MyBean;
import io.espinoleandroo.java.springboot.bean.MyBeanWithDependency;
import io.espinoleandroo.java.springboot.bean.MyBeanWithProperties;
import io.espinoleandroo.java.springboot.component.ComponentDependency;
import io.espinoleandroo.java.springboot.dao.User;
import io.espinoleandroo.java.springboot.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	Log LOGGER = LogFactory.getLog(Application.class);
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency beanWithDependency;
	private MyBeanWithProperties beanWithProperties;
	private User user;
	
	private UserRepository userRepository;
	
	public Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency beanWithDependency, MyBeanWithProperties beanWithProperties, User user, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependency = beanWithDependency;
		this.beanWithProperties = beanWithProperties;
		this.user = user;
		this.userRepository = userRepository;  
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpglFromUser();
	}
	
	private void getInformationJpglFromUser() {
		LOGGER.info("Usuario con el metodo findByUserEmail" + 
				userRepository.findByUserEmail("espinoleandroo@gmail.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
		
		userRepository.findAndSort("user", Sort.by("id").descending())
			.stream()
			.forEach(user -> LOGGER.info("Usuarion con metodo findAndSort" + user));
		
		userRepository.findByName("Leandro")
			.stream()
			.forEach(user -> LOGGER.info("Usuario con query method " + user));
		
		LOGGER.info("Usuario con query method findEmailAndName " + userRepository.findByEmailAndName("espinoleandroo@gmail.com", "Leandro")
			.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
		
		userRepository.findByNameLike("%user%")
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByNameLike" + user));
	
		userRepository.findByNameOrEmail("user9", "user0@outlook.com")
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByNameOrEmail" + user));
		
		userRepository.findByNameAndEmail("Leandro", "espinoleandroo@gmail.com")
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByNameAndEmail" + user));

		userRepository.findByBirthDateBetween(LocalDate.of(2021, 10, 31), LocalDate.of(2021, 11, 30))
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByBirthDateBetween" + user));

		userRepository.findByNameContainingOrderByIdDesc("user")
			.stream()
			.forEach(user -> LOGGER.info("Usuario findByNameContainingOrderByIdDesc" + user));

		
	
	}
	
	private void saveUsersInDataBase() {
		io.espinoleandroo.java.springboot.entity.User user1 = new io.espinoleandroo.java.springboot.entity.User("Leandro", "espinoleandroo@gmail.com", LocalDate.of(2021, 11, 11));
		io.espinoleandroo.java.springboot.entity.User user2 = new io.espinoleandroo.java.springboot.entity.User("user2", "user2@outlook.com", LocalDate.of(2021, 11, 11));
		io.espinoleandroo.java.springboot.entity.User user3 = new io.espinoleandroo.java.springboot.entity.User("user3", "user3@outlook.com", LocalDate.of(2021, 06, 23));
		io.espinoleandroo.java.springboot.entity.User user4 = new io.espinoleandroo.java.springboot.entity.User("user4", "user4@outlook.com", LocalDate.of(2021, 03, 01));
		io.espinoleandroo.java.springboot.entity.User user5 = new io.espinoleandroo.java.springboot.entity.User("user5", "user5@outlook.com", LocalDate.of(2021, 11, 25));
		io.espinoleandroo.java.springboot.entity.User user6 = new io.espinoleandroo.java.springboot.entity.User("user6", "user6@outlook.com", LocalDate.of(2021, 12, 20));
		io.espinoleandroo.java.springboot.entity.User user7 = new io.espinoleandroo.java.springboot.entity.User("user7", "user7@outlook.com", LocalDate.of(2021, 9, 07));
		io.espinoleandroo.java.springboot.entity.User user8 = new io.espinoleandroo.java.springboot.entity.User("user8", "user8@outlook.com", LocalDate.of(2021, 9, 7));
		io.espinoleandroo.java.springboot.entity.User user9 = new io.espinoleandroo.java.springboot.entity.User("user9", "user9@outlook.com", LocalDate.of(2021, 11, 25));
		io.espinoleandroo.java.springboot.entity.User user0 = new io.espinoleandroo.java.springboot.entity.User("user0", "user0@outlook.com", LocalDate.of(2021, 9, 7));
		
		List<io.espinoleandroo.java.springboot.entity.User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user0);
		
		list.stream().forEach(userRepository::save);
		
		
		
	}
	
	
	private void ejemplosAnteriores() {
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
