<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Languages</title>
	</head>
	<body>
		<table>
		<c:forEach items ="${ languages }" var = "language" varStatus = "loop"> 
		<%--https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm --%>
		<%--https://stackoverflow.com/questions/18825950/how-to-get-a-index-value-from-foreach-loop-in-jstl --%>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			<tr>
				<td><a href = "/languages/${loop.index}"><c:out value = "${language.name}"></c:out></a></td>
				<td><c:out value = "${language.creator }"></c:out></td>
				<td><c:out value = "${language.version }"></c:out></td>
				<td><a href = "">Delete</a>|<a href = "/edit/${loop.index}">Edit</a></td>
			</tr>
		</c:forEach>
		</table>
		<form:form method="POST" action="/new" modelAttribute="language">
			<form:label path = "name">Name
			<form:errors path = "name"/>
			<form:input path = "name"/></form:label>
			
			<form:label path = "creator">Creator
			<form:errors path = "creator"/>
			<form:input path = "creator"/></form:label>
			
			<form:label path = "version">Version
			<form:errors path = "version"/>
			<form:input path = "version"/></form:label>
			
			<input type = "submit" name = "submit"/>
		</form:form>
	</body>
</html>