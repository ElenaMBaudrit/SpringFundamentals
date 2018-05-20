<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	  	<style type="text/css"> <%@include file="skeleton.css"%></style>
		<style type="text/css"> <%@include file="style.css"%></style> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin page</title>
	</head>
	<body>
		<h1>Welcome to the Admin Page <c:out value="${currentUser.firstName}"></c:out></h1>
	    
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	    <a href = "/">Home</a>
	    <table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items = "${ all_Users }" var = "user">
					<tr>
						<td><c:out value = "${ user.firstName }"/> <c:out value = "${ user.lastName }"/></td>
						<td><c:out value = "${ user.email }"/></td>
						<c:choose>
							<c:when test = "${user.getRoles().contains(adminRole)}">
			        			<td>Admin</td>
					     	</c:when>
					     	<c:otherwise>
						        <td><a href ='/admin/delete/<c:out value="${user.getId()}"/>'>Delete</a> <a href ='/admin/mkAdmin/<c:out value="${user.getId()}"/>'>Make-admin</a></td>
						    </c:otherwise>
				     	</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>