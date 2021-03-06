
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="segment">
	<div class="head">
		<h2>Employees List</h2>
	</div>
	<div>
		<display:table name="sessionScope.employees" sort="list" pagesize="5" decorator="ca.web.employee.jpa.util.TimeDecorator"
			excludedParams="*">
			<display:column property="id" />
			<display:column property="firstName" sortName="firstName" sortable="true" />
			<display:column property="lastName" />
			<display:column property="dob" sortName="dob" sortable="true" />
			<display:setProperty name="paging.banner.placement" value="bottom" />
		</display:table>
	</div>
</div>