package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.EmployeeDAO;
import com.hcl.dto.CourseNameRequestDTO;
import com.hcl.dto.EmployeeRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.entity.Employee;
import com.hcl.exception.ErrorMessageException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	
	public ReponseDTO employeeRegistration(EmployeeRequestDTO employeeRequestDTO) throws ErrorMessageException {
		
		return employeeDAO.employeeRegistration(employeeRequestDTO);
	}

	
	public List<Employee> findByCourseName(CourseNameRequestDTO courseNameRequestDTO) throws ErrorMessageException {
		
		return employeeDAO.findByCourseName(courseNameRequestDTO);
	}
	
}
