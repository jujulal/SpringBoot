package com.example.Users.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByFirstName(String FirstName);
	List<User> findAll();
}
