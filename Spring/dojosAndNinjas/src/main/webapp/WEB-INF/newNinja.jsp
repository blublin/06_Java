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
<title>Add a Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container w-75 mx-auto">
		<h1 class="text-center">New Ninja</h1>
		<form:form action="/ninjas/processForm" method="post" modelAttribute="ninja"
			class="d-flex flex-column align-items-center border border-3 border-dark">
			<p>
				<form:errors path="dojo" cssClass=""/>
			</p>
			<p>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="d">
						<option value="${d.getId() }">${d.getName()}</option>
					</c:forEach>
				</form:select>
			</p>
			
			<p>
				<form:errors path="firstName" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="firstName">First Name:</form:label>
				<form:input class="col-12" path="firstName" />
			</p>

			<p>
				<form:errors path="lastName" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="lastName">Last Name:</form:label>
				<form:input class="col-12" path="lastName" />
			</p>

			<p>
				<form:errors path="age" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="age">Age:</form:label>
				<form:input class="col-12" path="age" />
			</p>
			<input type="submit" value="Submit" class="col-3" />
		</form:form>
	</div>
</body>
</html>