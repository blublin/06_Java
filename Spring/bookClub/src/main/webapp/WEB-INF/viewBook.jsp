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
	<div class="container w-75 mx-auto">
		<div
			class="container d-flex align-items-center justify-content-between">
			<h1 class="text-center">
				<c:out value="${ book.getTitle() }" />
			</h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<br />
		<c:out
			value="${book.getPoster().getId() eq user_id ? 'You' : book.getPoster().getUserName() } read ${book.getTitle() } by ${book.getAuthor() }" />
		<p>
			<c:out
				value="Here are ${ book.getPoster().getId() eq user_id ? 'your' : book.getPoster().getUserName() } thoughts" />
		</p>
		<hr />
		<div class="container">
			<p>
				<c:out value="${book.getThoughts() }"></c:out>
			</p>
		</div>
		<hr />
		<c:if test="${book.getPoster().getId() eq user_id }">
			<button class="btn btn-primary">Edit</button>
		</c:if>
	</div>
</body>
</html>