<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="segment">
	<div class="head">
		<h2>Find an Employee By ID</h2>
	</div>
	<div>
		<form method="POST" accept-charset="utf-8">
			<div class="field">
				<label for="idLbl">ID:</label>
				<div class="input">
					<input type="text" name="id" value="" id="id" title="ID" placeholder="A01234567"/>
				</div>
			</div>
			<div class="submit">
				<input type="hidden" name="action" value="service.findEmployees" />
				<input type="submit" name="submit" value="Search" id="submit" />
			</div>
		</form>


		<c:if test="${foundEmp ne null}">
			<c:out value="Found" />
			<c:out value="${foundEmp}" />
		</c:if>
		
		<c:if test="${fn:length( findResponseCode.code ) > 0}">
			<c:set var="code" value="Result Code: ${findResponseCode.code}" />
			<c:set var="desc" value="Description: ${findResponseCode.description}" />
			<c:out value="${code}" />
			<c:out value="${desc}" />
		</c:if>
	</div>

</div>
