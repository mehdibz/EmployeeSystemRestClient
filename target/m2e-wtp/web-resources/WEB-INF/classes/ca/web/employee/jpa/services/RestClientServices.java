package ca.web.employee.jpa.services;

import java.util.List;

import ca.web.employee.jpa.domain.ResponseCode;
import ca.web.employee.jpa.entity.*;

public interface RestClientServices {

	public ResponseCode addEmployee(Employee emp);
	public ResponseCode updateEmployeeById(Employee emp);
	public ResponseCode removeEmployeeById(String id);
	public ResponseCode findEmployeeById(String id);
	public List<Employee> getEmployeeList();
	public int status();
}
