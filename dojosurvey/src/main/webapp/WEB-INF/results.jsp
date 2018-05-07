<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Results</title>
	</head>
	<body>
		<h2>Submitted Info</h2>
		<ul>
			<li>
				<a>Name:</a>
				<a><c:out value="${name}"/></a>
			</li>
			<li>
				<a>Dojo Location:</a>
				<a><c:out value="${location}"/></a>
			</li>
			<li>
				<a>Favorite Language:</a>
				<a><c:out value="${language}"/></a>
			</li>
			<li>
				<a>Comment:</a>
				<a><c:out value="${comment}"/></a>
			</li>
		</ul>
	</body>
</html>