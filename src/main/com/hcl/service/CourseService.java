package com.hcl.service;

import com.hcl.dto.CourseRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.exception.ErrorMessageException;

public interface CourseService {
	public ReponseDTO createCourse(CourseRequestDTO courseRequestDTO) throws ErrorMessageException ;

}
