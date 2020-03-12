package ca.web.employee.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import ca.web.employee.jpa.services.RestClientServices;
import ca.web.employee.jpa.services.RestClientServicesImpl;



public abstract class AbstractCommand implements Command
{

	protected RestClientServices employeeServices;
	
	public AbstractCommand()
	{
		employeeServices = new RestClientServicesImpl();
	}
	
	public abstract void execute( HttpServletRequest request );
	
}
