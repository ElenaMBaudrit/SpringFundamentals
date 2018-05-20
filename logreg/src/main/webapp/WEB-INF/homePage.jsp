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
	
	<title>User Information</title>
	</head>
	<body>
   		<h1>Welcome <c:out value="${currentUser.firstName }"></c:out>!</h1>
		<ul>
			<li>First Name: <c:out value="${currentUser.firstName }"></c:out></li>
			<li>Last Name: <c:out value="${currentUser.lastName }"></c:out></li>
			<li>Email: <c:out value="${currentUser.email }"></c:out></li>
			<li>Sign Up Date: <c:out value="${currentUser.createdAt}"/></li>
			<li>Last Sign In: <c:out value="${currentUser.last_sign_in}"/></li>
		</ul>
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	</body>
</html>