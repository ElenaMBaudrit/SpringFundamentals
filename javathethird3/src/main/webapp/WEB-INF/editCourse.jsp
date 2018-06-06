<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit Course</title>
		<style type="text/css"><%@include file="/WEB-INF/css/skeleton.css" %></style>
		<style type="text/css"><%@include file="/WEB-INF/css/style.css" %></style>
	</head>
	<body>
	    <h1>Edit ${ lecture.name }</h1>
	    <form:form method="post" action="/courses/${ lecture.id }/edit" modelAttribute="lecture">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input type="text" path="name"/>
	    </p>
   	    <p>
	        <form:label path="instructor">Instructor:</form:label>
	        <form:errors path="instructor"/>
	        <form:input type="text" path="instructor"/>
	    </p>
      	<p>
	        <form:label path="el_limite">Limit:</form:label>
	        <form:errors path="el_limite"/>
	        <form:input type="number" path="el_limite"/>
	    </p>
	    <form:hidden path="id" value = "${lecture.id }"/>
	    <input type="submit" value="Update">
	    </form:form>
	    <a href="/courses/${lecture.id}/delete"><button>Delete</button></a>
	</body>

</html>