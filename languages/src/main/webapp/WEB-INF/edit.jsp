<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit (name of the language to be edited)</title>
	</head>
	<body>
		<div id = "top_links">
			<a href="/delete/${index}">Delete</a>
			<a href = "/">Dashboard</a>
		</div>
		<form action = "/edited/${index}" method = "post" modelAttribute="language">
			<ul>
				<li>Name:
					<ul>
						<li>Current information: <c:out value = "${language.name}"></c:out> </li>
						<li>New Name: <input type = "text" name = "name">
					</ul>
				</li>
				<li>Creator: 
					<ul>
						<li>Current information: <c:out value = "${language.creator}"></c:out> </li>
						<li>New Creator: <input type = "text" name = "creator"></li>
					</ul>
				</li>
				<li>Version: 
					<ul>
						<li>Current information: <c:out value = "${language.version}"></c:out> </li>
						<li>New Version: <input type = "text" name = "version"></li>
					</ul>
				</li>
			</ul>
			<input type = "submit" name = "submit">
		</form>
	</body>
</html>