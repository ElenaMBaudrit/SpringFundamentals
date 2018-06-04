<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<body>
    <h1>Welcome <c:out value="${currentUser.firstName}"></c:out></h1>
    <table>
    	<tbody>
    		<tr><td>First Name:<c:out value="${currentUser.firstName}"></c:out></td></tr>
    		<tr><td>Last Name:<c:out value="${currentUser.lastName}"></c:out></td></tr>
    		<tr><td>Email:<c:out value="${currentUser.username}"></c:out></td></tr>
    		<tr><td>Sign up date: <fmt:formatDate pattern="MMMM-dd-yyyy" value="${currentUser.createdAt}"/></td></tr>
			<tr><td>Last sign in: <fmt:formatDate pattern="MMMM-dd-yyyy" value="${logintime}"/></td></tr>
    	</tbody>
    
    
    </table>
    
    
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <a href="/admin">Go to Admin</a>
</body>
</html>