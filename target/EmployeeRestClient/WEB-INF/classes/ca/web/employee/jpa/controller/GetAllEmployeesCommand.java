package ca.web.employee.jpa.controller;

import javax.servlet.http.HttpServletRequest;

public class GetAllEmployeesCommand extends AbstractCommand
{
	@Override
	public void execute( HttpServletRequest request )
	{
			request.getSession().setAttribute( "employees", employeeServices.getEmployeeList() );
	}
}
