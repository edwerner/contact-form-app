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
		<jsp:include page="includes/navigation.jsp" />
		<h2>Service-Oriented Architecture Example</h2>
		<h4>Contact form REST API runs on Spring Framework, JUnit, Maven, Hibernate and MySQL.</h4>
		<br />
		<table class="table table-striped" border="1">
			<tr>
				<th>Car domain object</th>
				<th>Contact domain object</th>
			</tr>
			<tr>
				<td>
					<h5>Persists</h5>
					<ul>
						<li><code>Long</code> ID (Generated)</li>
						<li><code>String</code> Model</li>
					</ul>
				</td>
				<td>
					<h5>Persists</h5>
					<ul>
						<li><code>Long</code> ID (Generated)</li>
						<li><code>String</code> First Name</li>
						<li><code>String</code> Last Name</li>
						<li><code>String</code> Email Address</li>
						<li><code>String</code> Phone Number</li>
						<li><code>String</code> Message</li>
						<li><code>String</code> Model</li>
					</ul>
				</td>
			</tr>
		</table>
		<br />
	</div>
</body>

</html>

