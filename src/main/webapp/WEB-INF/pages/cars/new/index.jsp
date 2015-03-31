<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<!-- stylesheets -->
  <link href="http://getbootstrap.com/dist/css/bootstrap.css" rel="stylesheet">
  <link href="http://getbootstrap.com/examples/justified-nav/justified-nav.css" rel="stylesheet">
  <link href="../resources/css/application.css" rel="stylesheet" type="text/css"/>

<!-- javascripts -->
  <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script src="http://getbootstrap.com/dist/js/bootstrap.js"></script>
  <style>
  	.error {
  		color: red;
  		font-style: italic;
  	}

  	body, html {
  		margin: 20px;
  	}
  </style>

</head>
<body>
<div class="container">
	<jsp:include page="../../includes/navigation.jsp" />
	<h2>Add New Car</h2>
	<form:form method="post" action="index" commandName="car">
		<h3>Car Model</h3>
		<p><form:errors path="model" cssClass="error"/></p>
		<form:input path="model"/>
		<br />
		<br />
		<div><button class="btn btn-primary">Submit</button></div>
	</form:form>
</div>
</body>
</html>
