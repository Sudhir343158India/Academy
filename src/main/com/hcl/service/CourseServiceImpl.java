package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.CourseDAO;
import com.hcl.dto.CourseRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.exception.ErrorMessageException;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;

	@Override
	public ReponseDTO createCourse(CourseRequestDTO courseRequestDTO) throws ErrorMessageException {
		
		return courseDAO.createCourse(courseRequestDTO);
	}
}
