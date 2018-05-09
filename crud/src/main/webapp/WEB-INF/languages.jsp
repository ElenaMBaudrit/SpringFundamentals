<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Language (id of the language goes here)</title>
	</head>
	<body>
		<a href = "/">Dashboard</a>
		<ul>
	
			<li>Language name: <c:out value = "${language.name}"></c:out></li>
			<li>Creator: <c:out value = "${language.creator}"></c:out></li>
			<li>Version: <c:out value = "${language.version}"></c:out></li>
		
		</ul>
		<br>
		<a href = "/edit/${index}">Edit</a>
		<a href="/delete/${index}">Delete</a>
	</body>
</html>