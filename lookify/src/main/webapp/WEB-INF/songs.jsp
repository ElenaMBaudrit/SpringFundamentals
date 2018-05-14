<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Songs</title>
	</head>
	<body>
		<a href = "/dashboard">Dashboard</a>
		<ul>
			<li>Title: <a href='/songs/${song.id}'><c:out value="${ song.title } "></c:out></a></li>
			<li>Artist: <a href = "/search/${song.artist}"><c:out value="${song.artist}"/></a></li>
			<li>Rating (1-10):<c:out value="${song.rating}"/></li>
		</ul>
		<a href="/delete/{id}">Delete</a>
	</body>
</html>