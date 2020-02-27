package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.CourseNameRequestDTO;
import com.hcl.dto.EmployeeRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.entity.Employee;
import com.hcl.exception.ErrorMessageException;
import com.hcl.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ReponseDTO> employeeRegistration(@RequestBody EmployeeRequestDTO employeeRequestDTO)
			throws ErrorMessageException {

		return new ResponseEntity<ReponseDTO>(employeeService.employeeRegistration(employeeRequestDTO),
				HttpStatus.CREATED);
	}
	@RequestMapping(value = "/listofcourseemployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> findByCourseName(CourseNameRequestDTO courseNameRequestDTO)throws ErrorMessageException{
	
		return new ResponseEntity <List<Employee>>(employeeService.findByCourseName(courseNameRequestDTO),
				HttpStatus.OK);
	}
}
