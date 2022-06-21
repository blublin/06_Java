<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h2 class="text-center">Welcome!</h2>
	<div class="container w-75 mx-auto d-flex">
	
		
		<%-- Register --%>
		<div class="container w-75 mx-auto">
			<h1 class="text-center">Register</h1>
			<form:form action="/register" method="post" modelAttribute="regObj"
				class="d-flex flex-column align-items-center border border-3 border-dark">
				<p>
					<form:errors path="userName" cssClass="text-danger" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="userName">Username:</form:label>
					<form:input class="col-10" path="userName" />
				</p>

				<p>
					<form:errors path="email" cssClass="text-danger" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="email">Email:</form:label>
					<form:input class="col-10" path="email" />
				</p>

				<p>
					<form:errors path="password" cssClass="text-danger" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="password">Password:</form:label>
					<form:input class="col-10" path="password" />
				</p>

				<p>
					<form:errors path="confirm" cssClass="text-danger" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="confirm">Confirm Password:</form:label>
					<form:input class="col-10" path="confirm" />
				</p>
				<input type="submit" value="Submit" class="col-3" />
			</form:form>
		</div>
		
		<%-- Login --%>
		<div class="container w-75 mx-auto">
			<h1 class="text-center">Login</h1>
			<form:form action="/login" method="post" modelAttribute="loginObj"
				class="d-flex flex-column align-items-center border border-3 border-dark">
				<p>
					<form:errors path="email" cssClass="text-danger" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="email">Email:</form:label>
					<form:input class="col-10" path="email" />
				</p>

				<p>
					<form:errors path="password" cssClass="text-danger" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="password">Password:</form:label>
					<form:input class="col-10" path="password" />
				</p>
				<input type="submit" value="Submit" class="col-3" />
			</form:form>
		</div>
	</div>
</body>
</html>