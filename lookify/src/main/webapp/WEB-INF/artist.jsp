<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Artist's Songs</title>
	</head>
	<body>
		<div class = "top">
			<a>Songs by artist:<c:out value="${song[0].artist}"/></a>
			<form action = "/search"> 
				<input type = "text" name ="artist">
				<input type = "submit" name = "New Search">
			</form>
			<a href = "/dashboard">Dashboard</a>
		</div>
		<table>
			<c:forEach items ="${ song }" var = "lookify"> 
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
				<tr>
					<td><a href='/songs/${lookify.id}'><c:out value="${ lookify.title } "></c:out></a> </td>
					<td><c:out value="${lookify.rating}"></c:out><td>
					<td><a href="/delete/${lookify.id}">Delete</a></td>
				
			</c:forEach> 
			</table>
	</body>
</html>