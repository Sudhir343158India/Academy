package com.hcl.dao;

import com.hcl.dto.CourseRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.exception.ErrorMessageException;


public interface CourseDAO {

	public ReponseDTO createCourse(CourseRequestDTO courseRequestDTO) throws ErrorMessageException ;

}
