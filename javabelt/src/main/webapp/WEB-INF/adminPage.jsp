<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin Page</title>
	</head>
	<body>
		<h1>Welcome to the Admin Page <c:out value="${currentUser.firstName}"></c:out></h1>
		
		<table>
			<thead>
				<th>Name</th>
				<th>Email</th>
				<th>Actions</th>
			</thead>
			<c:forEach var="user" items="${users}">
			<tbody>
				<tr><td><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></td>
				<td> <c:out value="${user.username}"></c:out></td>
				<c:choose>
					<c:when test="${user.roles.contains(admin)}">
						<td>admin</td>
					</c:when>
					<c:otherwise>
						<td><a href="/delete/<c:out value="${user.id}"/>">delete</a> | <a href="/make-admin/<c:out value="${user.id}"/>">make-admin</a></td>
					</c:otherwise>
				</c:choose>
			</tbody>
			</c:forEach>
		</table>
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	        </form>
	</body>
</html>