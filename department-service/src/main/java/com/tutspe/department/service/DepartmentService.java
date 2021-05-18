package com.tutspe.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutspe.department.entity.Department;
import com.tutspe.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentService {

	@Autowired
	public DepartmentRepository departmentRepository;

	public Department save(Department department) {
		log.info("Inside save of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
