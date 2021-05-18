package com.tutspe.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tutspe.user.dto.DepartmentDto;
import com.tutspe.user.dto.ResponseTemplateDto;
import com.tutspe.user.entity.User;
import com.tutspe.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside the saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateDto getUserIdWithDepartment(long userId) {
		log.info("Inside the getUserIdWithDepartment of UserService");
		ResponseTemplateDto responseTemplateDto = new ResponseTemplateDto();
		User user = userRepository.findByUserId(userId);
		DepartmentDto departmentDto = restTemplate
				.getForObject("http://localhost:9091/departments/"+user.getDepartmentId(), DepartmentDto.class);
		responseTemplateDto.setUser(user);
		responseTemplateDto.setDepartmentDto(departmentDto);
		return responseTemplateDto;
	}
}
