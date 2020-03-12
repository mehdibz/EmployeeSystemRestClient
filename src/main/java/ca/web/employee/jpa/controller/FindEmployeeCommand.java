package ca.web.employee.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import ca.web.employee.jpa.domain.ResponseCode;
import ca.web.employee.jpa.util.PropertiesUtil;

public class FindEmployeeCommand extends AbstractCommand 
{	
	@Override
	public void execute(HttpServletRequest request)
	{
		ResponseCode responseCode = new ResponseCode();
		String empId = request.getParameter( "id" );
		Boolean resStatus = false;
		
		resStatus = employeeServices.findEmployeeById(empId).getCode().equals("000");

		if ( resStatus )
		{
			request.setAttribute( "foundEmp", employeeServices.findEmployeeById(empId).getDescription());
			responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "find.employee.success.code" ) );
			responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "find.employee.success.desc" ) );
		}
		else
		{
			responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "error.find.employee.code" ) );
			Object[] args = { empId };
			responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "error.find.employee.desc", args ) );	
		}
		request.setAttribute( "findResponseCode", responseCode );
	}

}
