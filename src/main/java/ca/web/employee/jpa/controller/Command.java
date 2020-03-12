 package ca.web.employee.jpa.controller;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;


public interface Command 
{
	static final String EMPLOYEE_BUNDLE_NAME = "employees-presentation";
	static final ResourceBundle EMPLOYEE_RESOURCE_BUNDLE = ResourceBundle.getBundle( EMPLOYEE_BUNDLE_NAME );
	public void execute( HttpServletRequest request ) throws Exception;
}
