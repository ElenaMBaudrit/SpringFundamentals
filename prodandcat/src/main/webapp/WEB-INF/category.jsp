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
		<title>Add a Product to the ${ category.name } Category</title>
	</head>
	<body>
		<div>
			<h1>${ category.name }</h1>
			<div>
				<h2>Products: </h2> <%--Similar to the one created for the Products (product.jsp) --%>
				<ul>
					<c:forEach var="product" items="${category.products}">
					<li> ${ product.name }</li>
					</c:forEach>
				</ul>
			</div>
			<div>
				<h3>Add Product:</h3>
				<form action="/categories/add/${category.id}" method="post">
					<select name="products">
						<c:forEach var="product" items="${products }">
							<c:if test="${!category.products.contains(product) }">
								<option value="${product.id }">${product.name }"</option>
							</c:if>
						</c:forEach>
					</select>
					<input type="submit" value="Add">
				</form>
			</div>
			<h4><a href="/categories/new">New Category</a></h4>
			<h4><a href="/products/new">New Product</a></h4>
			<h4><a href = "/products">To Add Categories to a Product</a></h4>
		</div>
	</body>
</html>