package com.tutspe.user.dto;

import com.tutspe.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateDto {

	private User user;
	private DepartmentDto departmentDto;
}
