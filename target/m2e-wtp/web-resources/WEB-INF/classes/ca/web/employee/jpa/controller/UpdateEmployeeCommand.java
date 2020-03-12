package ca.web.employee.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import ca.web.employee.jpa.domain.ResponseCode;
import ca.web.employee.jpa.entity.Employee;
import ca.web.employee.jpa.util.PropertiesUtil;


public class UpdateEmployeeCommand extends AbstractCommand
{

	@Override
	public void execute(HttpServletRequest request )
	{
		ResponseCode responseCode = new ResponseCode();
		Employee employee = new Employee();

		employee.setId( request.getParameter( "id" ) );
		employee.setFirstName(request.getParameter( "fname" ));
		employee.setLastName(request.getParameter( "lname" ));
		employee.setDob(request.getParameter( "dob" ));
		
		String status = "";

		status=employeeServices.updateEmployeeById(employee).getCode();
		//refresh the list:
		request.getSession().setAttribute( "employees", employeeServices.getEmployeeList() );

		if ( status.equals("001") )
		{
			responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "update.employee.success.code" ) );
			Object[] args ={ employee.getId() };
			responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "update.employee.success.desc",args ) );
		}
		else 
			{
				responseCode.setCode(employeeServices.updateEmployeeById(employee).getCode() );
				responseCode.setDescription( employeeServices.updateEmployeeById(employee).getDescription());
			}
		request.setAttribute( "updateResponseCode", responseCode );
	}

}
