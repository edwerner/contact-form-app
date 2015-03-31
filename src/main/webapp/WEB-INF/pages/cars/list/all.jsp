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
		<h2>List of Cars</h2>
		<table class="table table-striped" border="1">
			<tr>
				<th></th>
				<th>Model</th>
			</tr>
			<c:forEach var="car" items="${newCar}">
				<tr>
					<td><a href="<%=request.getContextPath()%>/cars/list/${car.id}">View</a></td>
					<td>${car.model}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>
