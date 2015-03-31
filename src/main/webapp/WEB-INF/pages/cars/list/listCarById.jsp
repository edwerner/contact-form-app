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
<script src="../resources/js/application.js"></script>
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
		<h2>Car Detail</h2>
		<div class="alert alert-danger fade in">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">×</button>
			<h4>Are you sure?</h4>
			<p>Deleting records is permanent.</p>
			<p>
				<button type="button" class="btn btn-danger delete-confirm">Delete
					Item</button>
			</p>
		</div>
		<div class="bs-callout bs-callout-info">
			<table class="table table-striped" border="1">
				<tr>
					<th></th>
					<th>Model</th>
				</tr>
				<tr>
					<td><a href="/deleteCar/${individualCar.id}">Delete</a></td>
					<td>${individualCar.model}</td>
				</tr>
			</table>
		</div>
	</div>
</body>

</html>

