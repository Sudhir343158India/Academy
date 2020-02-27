package com.hcl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.dto.CourseNameRequestDTO;
import com.hcl.dto.EmployeeRequestDTO;
import com.hcl.dto.ReponseDTO;
import com.hcl.entity.Employee;
import com.hcl.exception.ErrorMessageException;
import com.hcl.util.ApllicationUitils;
import com.hcl.util.SessionObject;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionObject sessionObject;
	Employee employee = new Employee();
	ReponseDTO responseDto = new ReponseDTO();

	@Override
	public ReponseDTO employeeRegistration(EmployeeRequestDTO employeeRequestDTO) throws ErrorMessageException {

		Optional<EmployeeRequestDTO> employeeRequestDTOOptional = Optional.of(employeeRequestDTO);
		if (!employeeRequestDTOOptional.isPresent()) {
			throw new ErrorMessageException(ApllicationUitils.COURSE_ERROR);
		}
		BeanUtils.copyProperties(employeeRequestDTO, employee);
		sessionObject.getSession().save(employee);
		responseDto.setMessage(ApllicationUitils.EMPLOYEE_Registred);

		responseDto.setStatusCode(HttpStatus.CREATED.value());

		return responseDto;
	}

	List<Employee> listOfEmployee = new ArrayList<Employee>();
	Employee employee1 = new Employee();

	@SuppressWarnings("unchecked")
	public List<Employee> findByCourseName(CourseNameRequestDTO courseNameRequestDTO) throws ErrorMessageException {
		
		Query query1 = sessionObject.getSession().createQuery(" from Employee e where e.courseName = :courseName ");
		query1.setParameter("courseName", courseNameRequestDTO.getCourseName());
		employee1 = (Employee) query1.uniqueResult();
		Optional<Employee> employeeOptional = Optional.ofNullable(employee1);

		if (!employeeOptional.isPresent()) {
			throw new ErrorMessageException(ApllicationUitils.List_Of_Course_Employees);
		}

		Query query = sessionObject.getSession()
				.createQuery(" select c.courseId,c.courseName " + " from Course c " + " where c.courseId in ( "
						+ " select e.courseId " + " from Empolyee e "
						+ " where e.courseName = :courseName or e.courseName like '%'||:courseName||'%'  ))");

		query.setParameter("courseName", courseNameRequestDTO.getCourseName());

		listOfEmployee = query.list();

		return listOfEmployee;
	
	}

}
