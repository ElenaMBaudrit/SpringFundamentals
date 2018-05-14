<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Song</title>
	</head>
	<body>
		<div class = "top">
			<h1>Add a New Song:</h1>
			<a href = "/dashboard">Dashboard</a>
		</div>	
		<form:form action = "/add_new_song" method = "POST" modelAttribute = "song">
		<form:hidden path="id"/>
			<form:label path = "title">Title
			<form:errors path = "title"/>
			<form:input path = "title"/></form:label>
			
			<form:label path = "artist">Artist
			<form:errors path = "artist"/>
			<form:input path = "artist"/></form:label>
			
			<form:label path = "rating">Rating
			<form:errors path = "rating"/>
			<form:input type = "number" path = "rating" min = "0" max = "10"/></form:label>
		
			<input type = "submit" name = "Add Song">
		</form:form>
	</body>
</html>