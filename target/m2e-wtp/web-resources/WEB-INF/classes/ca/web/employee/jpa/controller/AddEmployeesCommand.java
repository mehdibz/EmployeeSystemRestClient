package ca.web.employee.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import ca.web.employee.jpa.domain.ResponseCode;
import ca.web.employee.jpa.entity.Employee;
import ca.web.employee.jpa.util.PropertiesUtil;

public class AddEmployeesCommand extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request)  
	{
		ResponseCode responseCode = new ResponseCode();
		Employee employee = new Employee();
		String status="init";
		
		employee.setId( request.getParameter("id") );
		employee.setFirstName( request.getParameter( "fname" ) );
		employee.setLastName( request.getParameter( "lname" ) );
		employee.setDob(request.getParameter( "dob" ));

		status=employeeServices.addEmployee(employee).getCode();

		if (status.equals("000"))
		{
			responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "add.employee.success.code" ) );
			Object[] args = { employee.getFirstName(), employee.getLastName() };
			responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "add.employee.success.desc", args ) );
			//refresh the list
			request.getSession().setAttribute( "employees", employeeServices.getEmployeeList() );
		} else {
			if(status.equals("902")) 
			{
				responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "error.add.employee.duplicate.code" ) );
				Object[] args = { employee.getFirstName(), employee.getLastName() };
				responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "error.add.employee.duplicate.desc", args ) );
				//refresh the list
				request.getSession().setAttribute( "employees", employeeServices.getEmployeeList() );
			}
			else{
				responseCode.setCode( employeeServices.addEmployee(employee).getCode());
				responseCode.setDescription( employeeServices.addEmployee(employee).getDescription() );
				//refresh the list
				request.getSession().setAttribute( "employees", employeeServices.getEmployeeList() );
			}
		}

		request.setAttribute( "addResponseCode", responseCode );
	}	
}
