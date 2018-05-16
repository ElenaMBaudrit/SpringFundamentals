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
		<title>Add a New Category for THE PRODUCT</title>
	</head>
	<body>
		<div>
			<h1>Add a Category to ${ product.name }</h1>
			<ul>
				<c:forEach var="category" items="${product.categories}">
				<li>${category.name}</li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<h3>Add Category:</h3>
			<form action ="/products/add/${product.id}" method = "post">
				<select name = "categories">
					<c:forEach var = "category" items = "${categories }"> <%--The if is to check if the product is already linked to the "new" category --%>
						<c:if test = "${!product.categories.contains(category) }">
							<option value = "${category.id }"> ${category.name}</option>
						</c:if>
					</c:forEach>
				</select>
				<input type = "submit" value="Add">
			</form>
		</div>
		<h4><a href="/categories/new">New Category</a></h4>
		<h4><a href="/categories">Go to Add Product to a Category</a></h4>
		<h4><a href = "/products">To Add Categories to a Product</a></h4>
	</body>
</html>