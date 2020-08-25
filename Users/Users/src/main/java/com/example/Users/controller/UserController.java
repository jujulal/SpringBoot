package com.example.Users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Users.service.User;
import com.example.Users.service.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/getusers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping("/adduser")
	public User addUser() {
		User user = new User();
		user.setFirstName("Bibek");
		user.setLastName("Shrestha");
		user.setEmail("bibek@email.com");
		user.setUserName("bib");
		
		return userRepository.save(user);
	}
}
