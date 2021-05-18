package com.tutspe.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutspe.user.dto.ResponseTemplateDto;
import com.tutspe.user.entity.User;
import com.tutspe.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside the saveUser of UserController");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	private ResponseTemplateDto getUserWithDepartmentDto(@PathVariable("id") long userId) {
		return userService.getUserIdWithDepartment(userId);
	}
}
