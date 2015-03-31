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
	<h2>Add New Contact</h2>
	<form:form method="post" action="index" commandName="contact">
		<h3>First Name</h3>
		<p><form:errors path="firstName" cssClass="error"/></p>
		<form:input path="firstName"/><br /><br />
		<h3>Last Name</h3>
		<p><form:errors path="lastName" cssClass="error"/></p>
		<form:input path="lastName"/><br /><br />
		<h3>Email</h3>
		<p><form:errors path="emailAddress" cssClass="error"/></p>
		<form:input path="emailAddress"/><br /><br />
		<h3>Phone</h3>
		<p><form:errors path="phoneNumber" cssClass="error"/></p>
		<form:input path="phoneNumber"/><br /><br />
		<h1>Choose a Model</h1>
		<form:select path="model">
			<option>Choose a Model</option>
			<c:forEach var="car" items="${carChoices}">
	  			<option value="${car.model}" <c:if test="${contact.model eq car.model}">selected="selected"</c:if>>${car.model}</option>
			</c:forEach>
		</form:select>
		<p><form:errors path="model" cssClass="error"/></p>
		<h3>Message</h3>
		<p><form:errors path="message" cssClass="error"/></p>
		<form:textarea path="message" rows="4" cols="50"></form:textarea>
		<br />
		<br />
		<div><button class="btn btn-primary">Submit</button></div>
	</form:form>
</div>
</body>
</html>
