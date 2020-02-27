package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.CourseRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.exception.ErrorMessageException;
import com.hcl.service.CourseService;

@RequestMapping("/courses")
@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/added", method = RequestMethod.POST)
	public ResponseEntity<ReponseDTO> createCourse(@RequestBody CourseRequestDTO courseRequestDTO)
			throws ErrorMessageException {

		return new ResponseEntity<ReponseDTO>(courseService.createCourse(courseRequestDTO), HttpStatus.CREATED);
	}
}
