<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- stylesheets -->
<link href="http://getbootstrap.com/dist/css/bootstrap.css"
	rel="stylesheet">
<link
	href="http://getbootstrap.com/examples/justified-nav/justified-nav.css"
	rel="stylesheet">
<link href="../resources/css/application.css" rel="stylesheet"
	type="text/css" />

<!-- javascripts -->
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.js"></script>
<style>
.error {
	color: red;
	font-style: italic;
}

body,html {
	margin: 20px;
}
</style>

</head>
<body>
	<div class="container">
		<jsp:include page="../../includes/navigation.jsp" />
		<h2>Contact Detail</h2>
		<table class="table table-striped" border="1">
			<tr>
				<th></th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Phone Number</th>
				<th>Message</th>
				<th>Model</th>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath()%>/contacts/delete/${individualContact.id}">Delete</a></td>
				<td>${individualContact.firstName}</td>
				<td>${individualContact.lastName}</td>
				<td>${individualContact.emailAddress}</td>
				<td>${individualContact.phoneNumber}</td>
				<td>${individualContact.message}</td>
				<td>${individualContact.model}</td>
			</tr>
		</table>
	</div>
</body>

</html>

