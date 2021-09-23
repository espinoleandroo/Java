package io.espinoleandroo.java.springboot.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.espinoleandroo.java.springboot.dto.UserDto;
import io.espinoleandroo.java.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	Optional<User> findByUserEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.name LIKE ?1%")
	List<User> findAndSort(String name, Sort sort);
	
	List<User> findByName(String name);
	Optional<User> findByEmailAndName(String email, String name);
	
	List<User> findByNameLike(String name);
	
	List<User> findByNameOrEmail(String name, String email);
	
	List<User> findByNameAndEmail(String name, String email);
	
	List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
	
	List<User> findByNameContainingOrderByIdDesc(String Name);
	
	@Query("SELECT new io.espinoleandroo.java.springboot.dto.UserDto(u.id, u.name, u.birthDate)"
			+ " FROM User u "
			+ " WHERE u.birthDate = :paramDate "
			+ " AND u.email = :paramEmail ")
	Optional<UserDto> getAllByBirthDateAndEmail(@Param("paramDate") LocalDate date, @Param("paramEmail") String email);
}
