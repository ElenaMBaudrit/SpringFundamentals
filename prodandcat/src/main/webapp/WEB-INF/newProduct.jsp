<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <style type="text/css"> <%@include file="skeleton.css"%></style>
		<style type="text/css"> <%@include file="style.css"%></style> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Product</title>
	</head>
	<body>
		<h1>New Product</h1>
		<%--This kind of form works better when there's validation. In this case, it is for practice purposes only --%>
		<form:form action="/products/add" modelAttribute="product" method="post">
			<form:errors path ="name"/>
			<form:label path="name">Name
			<form:input type= "text" path = "name"/></form:label>
			
			<form:errors path="description"/>
			<form:label path="description">Description
			<form:input type= "text" path = "description"/></form:label>
			
			<form:errors path="price"/>
			<form:label path="price">Price
			<form:input type="text" path="price"/></form:label>		
			
			<input type="submit" value="Create"/>
		</form:form>
		<h4><a href="/categories/new">New Category</a></h4>
		<h4><a href="/categories">Go to Add Product to a Category</a></h4>
		<h4><a href="/products/new">Go to New Products</a></h4>
	</body>
</html>