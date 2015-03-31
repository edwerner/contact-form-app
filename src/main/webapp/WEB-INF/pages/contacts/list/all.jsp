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
    <h2>List of Contacts</h2>
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
        <c:forEach var="contact" items="${newContact}">
            <tr>
            	<td><a href="<%=request.getContextPath()%>/contacts/list/${contact.id}">View</a></td>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.emailAddress}</td>
                <td>${contact.phoneNumber}</td>
                <td>${contact.message}</td>
                <td>${contact.model}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
