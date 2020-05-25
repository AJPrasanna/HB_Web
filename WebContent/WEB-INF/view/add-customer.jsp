<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Add Customer</title>
<link type="tesxt/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="tesxt/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wraaper">
	<div id="header">
	<h2>Customer Addition Form</h2>
	</div>
</div>
<div id="container">
	<h3>Add Customer</h3>
	<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	<form:hidden path="id"/>
	<table>
		<tbody>
		<tr>
		<td><label>First Name : </label></td>
		<td><form:input path="firstName"/></td>
		</tr>
		
		<tr>
		<td><label>Last Name : </label></td>
		<td><form:input path="lastName"/></td>
		</tr>
		
		<tr>
		<td><label>Email : </label></td>
		<td><form:input path="email"/></td>
		</tr>
		
		
		<tr>
		<td><label></label></td>
		<td><button type="submit" class="save">Save</button></td>
		</tr>
		
		</tbody>
	</table>
	</form:form>
	<div style="clear; both;">
	<p>
	<a href="${pageContext.request.contextPath}/customers/list">Show Customer List</a>
	</p>
	</div>
</div>
</body>
</html>