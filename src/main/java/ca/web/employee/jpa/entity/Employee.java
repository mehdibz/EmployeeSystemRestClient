package ca.web.employee.jpa.entity;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Employee
{

	@NotNull
	private String ID;
	

	@NotNull
	private String firstName;
	

	@NotNull
	private String lastName;
	

	@NotNull
	private String dob;

	public String getId() {
		return ID;
	}

	public void setId(String id2) {
		this.ID = id2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + ID + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob +"]";
	}
}
