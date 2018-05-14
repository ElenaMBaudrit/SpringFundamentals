<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lookify Dashboard</title>
	</head>
	<body>
		<div id = "top">
			<a href = "/new_song">Add New |</a>
			<a href = "/top_Ten">Top Songs</a>
			<form action = "/search"> 
				<input type = "text" name ="artist">
				<input type = "submit" name = "New Search">
			</form>
		</div>
		<table>
		<c:forEach items ="${ song }" var = "lookify"> <%--"song = model name. lookify: how the attribute will be defined --%>
		<%--https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm --%>
		<%--https://stackoverflow.com/questions/18825950/how-to-get-a-index-value-from-foreach-loop-in-jstl --%>
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