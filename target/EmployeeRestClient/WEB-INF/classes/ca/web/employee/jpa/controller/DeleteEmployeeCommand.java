package ca.web.employee.jpa.controller;

import javax.servlet.http.HttpServletRequest;

import ca.web.employee.jpa.domain.ResponseCode;
import ca.web.employee.jpa.entity.Employee;
import ca.web.employee.jpa.util.PropertiesUtil;

public class DeleteEmployeeCommand extends AbstractCommand
{
	@Override
	public void execute( HttpServletRequest request )
	{
		Employee employee = new Employee();
		String pId = request.getParameter( "id" );
		employee.setId( pId );
		ResponseCode responseCode = new ResponseCode();
		Boolean success = false;
		

		success=employeeServices.removeEmployeeById(pId).getCode().equals("001");
		//refresh the list:
		request.getSession().setAttribute( "employees", employeeServices.getEmployeeList() );

		if ( success)
		{
			responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "remove.employee.success.code" ) );
			Object[] args ={ employee.getId() };
			responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "remove.employee.success.desc", args ) );
		}
		else
		{
			responseCode.setCode( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "error.remove.employee.code" ) );
			Object[] args = { employee.getId() };
			responseCode.setDescription( PropertiesUtil.getString( EMPLOYEE_RESOURCE_BUNDLE, "error.remove.employee.desc", args ) );
		}
		request.setAttribute( "delResponseCode", responseCode );
	}
}
