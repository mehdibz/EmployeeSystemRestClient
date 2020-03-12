<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="segment">
	<div class="head">
		<h2>Update Employees</h2>
	</div>
	<div>
		<form method="POST" accept-charset="utf-8">
			<div class="field">
				<label for="idLbl">ID:</label>
				<div class="input">
					<input type="text" name="id" value="" id="id" title="ID" placeholder="A01234567"/>
				</div>
			</div>
			<div class="field">
				<label for="fnLbl">First Name:</label>
				<div class="input">
					<input type="text" name="fname" value="" id="fname"
						title="First Name" />
				</div>
			</div>
			<div class="field">
				<label for="lnLbl">Last Name:</label>
				<div class="input">
					<input type="text" name="lname" value="" id="lname"
						title="Last Name" />
				</div>
			</div>
			<div class="field">
				<label for="lnLbl">DOB:</label>
				<div class="input">
					<input type="text" name="dob" value="" id="dob"
						title="Date of Birth" placeholder="YYYY/MM/DD" />
				</div>
			</div>
			<div class="submit">
				<input type="hidden" name="action" value="service.updateEmployees" />
				<input type="submit" name="submit" value="Update Employee" id="submit" />
			</div>
		</form>

		<c:if test="${fn:length( updateResponseCode.code ) > 0}">
			<c:set var="code" value="Result Code: ${updateResponseCode.code}" />
			<c:set var="desc" value="Description: ${updateResponseCode.description}" />
			<c:out value="${code}" />
			<c:out value="${desc}" />
		</c:if>

	</div>
</div>