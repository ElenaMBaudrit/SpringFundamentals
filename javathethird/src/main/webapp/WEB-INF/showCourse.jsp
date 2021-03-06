<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show Course</title>
		<style type="text/css"><%@include file="/WEB-INF/css/skeleton.css" %></style>
		<style type="text/css"><%@include file="/WEB-INF/css/style.css" %></style>
	</head>
	<body>
		<h1>${ lecture.name }</h1>
	    <table>
	        <tbody>
	            <tr>
	                <td><h4>Instructor:</h4></td>
	                <td><h4>${ lecture.instructor }</h4></td>
	            </tr>
	            <tr>
        		    <td><h4>Sign Ups:</h4></td>
	     			<td><h4>${ signUp.get(findAll()) }</h4></td> 
	            </tr>
	        </tbody>
	    </table>
	    <table>
	        <thead>
	            <tr>
	                <th><h3>Name</h3></th>
	                <th><h3>Sign Up Date</h3></th>
	                <th><h3>Action</h3></th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${ lectures }" var="lecture">
	                <tr>
	                    <td><h4>${ user.name }</h4></td>
	       			    <td><h4>${ user.signup }</h4></td> 	<%--THIS COULD BE IT! --%>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
		<a href = "/courses/${lecture.id}/edit"><button>Edit</button></a>
		<a href="/courses/${lecture.id}/delete"><button>Delete</button></a>
		<p>
		<a href="/courses">Go back to Dashboard</a>
		</p>
	</body>
</html>