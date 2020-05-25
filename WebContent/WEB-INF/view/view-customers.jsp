<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Home page</title>
<link type="text/css"
	  rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">

	<div id="header">
	<h2>Customer Tracker</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	<input type="button" value="Add Customer"
			onclick="window.location.href='addCustomer'; return false;"
			class="add-button"
			/>
		<table>
		
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
				
				<c:url var="updatelink" value="update">
				<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<c:url var="deletelink" value="delete">
				<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<td>
				<a href="${updatelink}">Update</a>
				|
				<a href="${deletelink}">Delete</a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>