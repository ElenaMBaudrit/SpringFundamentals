<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New License</title>
	</head>
	<body>
		<h1>New License</h1>
		<form:form action = "/person/add_new_license" method = "POST" modelAttribute = "license">
		<form:hidden path="id"/>
			<form:label path = "personName">Person: HERE MUST COME THE DROPDOWN (SELECT TYPE) MENU WITH THE PERSON'S NAME.
			<form:errors path = "personName"/>
				<form:select path = "personName">
				<c:forEach var="personName" items="${persons} }">
					<c:if test="${personName.license == null} }">
					<option value="${personName.id }"> <c:out value="${personName.firstName} }"/></option>
					</c:if>
				</c:forEach>
			</form:select>form:select></form:label>
			
			<form:label path = "state">State
			<form:errors path = "state"/>
			<form:input path = "state"/></form:label>
			
			<form:label path = "expDate">Expiration Date
			<form:errors path = "expDate"/>
			<form:input path = "expDate"/></form:label>
			
			<form:hidden value="${ licenseNum }" path="licenseNum"/>
			
			<input type = "submit" name = "Create"/>
		</form:form>
	</body>
</html>