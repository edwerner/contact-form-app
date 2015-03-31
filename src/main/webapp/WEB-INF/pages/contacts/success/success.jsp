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
	<h1><span class="label label-success">Success!</span></h1>
	<br />
	<p>${contact.firstName}, thank you for contacting us.</p>
	<p>You will be contacted at <i>${contact.emailAddress}</i> or <i>${contact.phoneNumber}</i>
	within seven (7) days.</p>

	<br />
<%-- 	<p><i>The info provided by you:</i></p>
	<p><b>First Name: </b>${contact.firstName}</p>
	<p><b>Last Name: </b>${contact.lastName}</p>
	<p><b>Email Address: </b>${contact.emailAddress}</p>
	<p><b>Phone Number: </b>${contact.phoneNumber}</p>
	<p><b>Message: </b>${contact.message}</p>
	<p><b>Model: </b>${contact.model}</p> --%>
</div>
</body>
</html>
