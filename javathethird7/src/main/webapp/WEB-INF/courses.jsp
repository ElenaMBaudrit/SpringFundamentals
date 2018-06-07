<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Courses</title>
	<style type="text/css"><%@include file="/WEB-INF/css/skeleton.css" %></style>
	<style type="text/css"><%@include file="/WEB-INF/css/style.css" %></style>
	</head>
	<body>
		<h1 id="welcome">Welcome, <c:out value="${currentUser.name}"/></h1>
		    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	    <h3>Courses</h3>
	    <%-- To display the error messages when the course has been already accepted --%>
	    <c:set var = "errors" value = "${errors}"/>
        <c:if test = "${not empty errors}">
            <p><c:out value="${errors}"/></p>
        </c:if>
	    <a href="/courses/order_asc"><button>Ascending Order</button></a>
	    <a href="/courses/order_desc"><button>Descending Order</button></a>
	    <table>
	        <thead>
	            <tr>
	                <th>Course</th>
	                <th>Instructor</th>
	                <th>Sign Ups</th>
	                <th>Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${ lecture }" var="lecture">
	            	<c:set var = "err" value = "0"/>
	                <tr>
	                    <td><a href="/courses/${ lecture.id }">${ lecture.name }</a></td>
	                    <td>${ lecture.instructor }</td>
	                    <td>${lecture.signUps.size() } / ${lecture.el_limite }</td>
	                    <td>
	                    
	                    <c:forEach items="${ lecture.signUps }" var="su">
		                    <c:if test = "${su.user.id == currentUser.id && su.lecture.id == lecture.id}">
					            <p><c:out value="You have already signed up for this course!"/></p>
					            <c:set var = "err" value = "1"/>
					        </c:if>
	                    </c:forEach>
	                    
	                    <c:if test = "${lecture.signUps.size() >= lecture.el_limite}">
				            <p><c:out value="This lecture cannot accept new Singups"/></p>
				            <c:set var = "err" value = "1"/>
				        </c:if>
	                    
	                    <c:if test = "${err != '1'}">
	                    	<a href="/courses/${lecture.id}/signup"><button>Add</button></a>
	                    </c:if>
	                    
						
						</td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <a href="/courses/new"><button>Add a course</button></a>
	</body>
</html>