<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ninja Gold</title>
	</head>
	<body>
		<h2>Your Gold: <c:out value="${gold}"/> </h2>
		<div id = "places">
			<ul>
				<li><h2>Farm</h2></li>
				<li><h3>(earns 10-20 gold)</h3></li>
				<li>
					<form action = "/process" method = "post">
						<input type = "hidden" name = "golden_reward" value = "farm">
						<button type = "submit">Find Gold!</button>
					</form>
				</li>
			</ul>
			<ul>
				<li><h2>Cave</h2></li>
				<li><h3>(earns 5-10 gold)</h3></li>
				<li>
					<form action = "/process" method = "post">
						<input type = "hidden" name = "golden_reward" value = "cave">
						<button type = "submit">Find Gold!</button>
					</form>
				</li>
			</ul>
			<ul>
				<li><h2>House</h2></li>
				<li><h3>(earns 2-5 gold)</h3></li>
				<li>
					<form action ="/process" method = "post">
						<input type = "hidden" name = "golden_reward" value = "house">
						<button type = "submit">Find Gold!</button>
					</form>
				</li>
			</ul>
			<ul>
				<li><h2>Casino!</h2></li>
				<li><h3>(earns/takes 0-50 gold)</h3></li>
				<li>
					<form action ="/process" method = "post">
						<input type = "hidden" name = "golden_reward" value = "house">
						<button type = "submit">Find Gold!</button>
					</form>
				</li>
			</ul>
		</div>
		<h2> Activities</h2>
		<ul>
			<li>
				<c:forEach var = "element" items = "${ game_results }">
				<c:out value="${ element }" escapeXml="false"/>
				</c:forEach>
			</li>
		
		</ul>
	</body>
</html>