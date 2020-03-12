package ca.web.employee.jpa.services;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import ca.web.employee.jpa.domain.ResponseCode;
import ca.web.employee.jpa.entity.Employee;

public class RestClientServicesImpl implements RestClientServices {

	private Client client = ClientBuilder.newClient();
	private Response response;
	

	@Override
	public ResponseCode findEmployeeById(String id) {

		response = client.target(getBaseURI("findEmployeeById/"+id))
						 .path("")
						 .request()
						 .get();

		ResponseCode rs= response.readEntity(ResponseCode.class);
		return rs;
	}
	
	@Override
	public ResponseCode addEmployee(Employee emp) {

		Form form = new Form();
        form.param("ID", emp.getId())
        	.param("firstName", emp.getFirstName())
        	.param("lastName", emp.getLastName())
        	.param("dob",emp.getDob() );
        
        Entity<Form> entity = Entity.form(form);
		response = client.target(getBaseURI("addEmployee/"))
				 .path("")
				 .request()
				 .post(entity);
		return response.readEntity(ResponseCode.class);
	}

	@Override
	public ResponseCode updateEmployeeById(Employee emp) {
		MultivaluedMap<String, Object> body = new MultivaluedHashMap<String, Object>();
		body.add("id", emp.getId());
		body.add("firstName", emp.getFirstName());
		body.add("lastName", emp.getLastName());
		body.add("dob", emp.getDob());

	
        
		Form form = new Form();
        form.param("ID", emp.getId())
        	.param("firstName", emp.getFirstName())
        	.param("lastName", emp.getLastName())
        	.param("dob",emp.getDob() );
        
        Entity<Form> entity = Entity.form(form);
		
        response = client.target(getBaseURI("updateEmployee/"))
				 .path("")
				 .request()
				 .put(entity);

		ResponseCode rs = response.readEntity(ResponseCode.class);
		return rs;
	}

	@Override
	public ResponseCode removeEmployeeById(String id) {

		response = client.target(getBaseURI("removeEmployee/"+id))
				 .path("")
				 .request()
				 .delete();
		ResponseCode rs = response.readEntity(ResponseCode.class);
		return rs;
	}

	@Override
	public List<Employee> getEmployeeList() {

		response = client.target(getBaseURI("employeeList"))
				 .path("")
				 .request()
				 .get();
		
		List<Employee> ls = response.readEntity(new GenericType<List<Employee>>() {});
		return ls;
	}
	
	@Override
	public int status() {
		
		return response.getStatus();
	}
	
	private static URI getBaseURI(String partialPath)	{

		return UriBuilder.fromUri("http://127.0.0.1:8080/EmployeeSystemRestWS/rest/services/"+partialPath).build();
	}
}
