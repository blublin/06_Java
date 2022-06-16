<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container w-75 mx-auto">
		<h1 class="text-center">New Dojo</h1>
		<form:form action="/dojos/processForm" method="post" modelAttribute="dojo"
			class="d-flex flex-column align-items-center border border-3 border-dark">
			
			<p>
				<form:errors path="name" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="name">First Name:</form:label>
				<form:input class="col-12" path="name" />
			</p>
			<input type="submit" value="Submit" class="col-3" />
		</form:form>
	</div>
</body>
</html>