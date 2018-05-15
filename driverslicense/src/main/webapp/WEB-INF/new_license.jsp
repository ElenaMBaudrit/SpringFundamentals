<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New License</title>
	</head>
	<body>
		<h1>${ person.firstName }  ${ person.lastName }</h1>
		<h3>License number: ${person.license.licenseNum }</h3>
		<h3>State: ${ person.license.state }</h3>
		<h3>Expiration date: $ {person.license.expDate }</h3>
	</body>
</html>