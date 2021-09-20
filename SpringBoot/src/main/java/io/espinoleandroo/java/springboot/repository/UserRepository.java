package io.espinoleandroo.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.espinoleandroo.java.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
