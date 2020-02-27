package com.hcl.dao;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.dto.CourseRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.entity.Course;
import com.hcl.exception.ErrorMessageException;
import com.hcl.util.ApllicationUitils;
import com.hcl.util.SessionObject;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	SessionObject session;

	Course course = new Course();
	ReponseDTO responseDto = new ReponseDTO();

	@Override
	public ReponseDTO createCourse(CourseRequestDTO courseRequestDTO) throws ErrorMessageException {

		Optional<CourseRequestDTO> courseRequestDTOOptional = Optional.of(courseRequestDTO);
		if (!courseRequestDTOOptional.isPresent()) {
			throw new ErrorMessageException(ApllicationUitils.COURSE_ERROR);
		}
		BeanUtils.copyProperties(courseRequestDTO, course);
		session.getSession().save(course);
		responseDto.setMessage(ApllicationUitils.COURSE_ADDED);

		responseDto.setStatusCode(HttpStatus.CREATED.value());

		return responseDto;
	}

}
