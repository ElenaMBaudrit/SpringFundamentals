<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dojo Survey</title>
	</head>
	<body>
		<form action= "/process" method = "post">
			<ul>
				<li>
					<h3>Your Name:</h3>
					<input type = "text" name = "name">
				</li>
				<li>
					<h3>Dojo Location:</h3>
					<select name = "location">
						<option value = "Seattle">Seattle</option>
						<option value = "Arizona">Arizona</option>
						<option value = "San Jose">San Jose</option>
					</select>
				</li>
				<li>
					<h3>Favorite Language:</h3>
					<select name = "language">
						<option value = "HTML">HTML</option>
						<option value = "JavaScript">JavaScript</option>
						<option value = "CSS">CSS</option>
						<option value = "Python">Python</option>
						<option value = "Java">Java</option>
					</select>
				</li>
				<li>
					<h3>Comment (optional):</h3>
					<textarea name = "comment" rows = "10" cols = "30"></textarea>
				</li>
			</ul>
			<a href = "/process"><button>Submit</button></a>
		</form>
	</body>
</html>