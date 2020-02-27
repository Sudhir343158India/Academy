package com.hcl.service;

import java.util.List;

import com.hcl.dto.CourseNameRequestDTO;
import com.hcl.dto.EmployeeRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.entity.Employee;
import com.hcl.exception.ErrorMessageException;

public interface EmployeeService {
	public ReponseDTO employeeRegistration(EmployeeRequestDTO employeeRequestDTO) throws ErrorMessageException ;
	public List<Employee> findByCourseName(CourseNameRequestDTO courseNameRequestDTO)throws ErrorMessageException;
	}

