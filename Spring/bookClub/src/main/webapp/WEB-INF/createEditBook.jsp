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
	<%-- New Book --%>
	<div class="container w-75 mx-auto">
		<div
			class="container d-flex align-items-center justify-content-between">

			<c:if test="${edit }">
				<h1>Edit Book</h1>
			</c:if>

			<c:if test="${edit eq null }">
				<h1>Add a book to your shelf!</h1>
				<a href="/dashboard">Return to the Shelf</a>
				<!-- <p>User ID Test: ${user.getUserName() } ${user.getId() }</p> -->
			</c:if>

		</div>
		<form:form action="/books/process${edit ? '/' : '' }${edit ? book.getId() : '' }" method="post" modelAttribute="book"
			class="d-flex flex-column align-items-center border border-3 border-dark">
			<c:if test="${edit }">
				<!-- IF EDIT, NOT CREATE, SET TO METHOD TO PUT -->
				<input type="hidden" name="_method" value="put">
				<!-- include id of already existing book -->
				<form:hidden path="id" />
			</c:if>

			<!-- INCLUDE USER AS POSTER WITH HIDDEN VALUE -->
			<form:hidden path="poster" value="${user_id }" />
			<p>
				<form:errors path="title" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="title">Title:</form:label>
				<form:input class="col-10" path="title" />
			</p>

			<p>
				<form:errors path="author" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="author">Author:</form:label>
				<form:input class="col-10" path="author" />
			</p>

			<p>
				<form:errors path="thoughts" cssClass="text-danger" />
			</p>
			<p class="d-flex">
				<form:label class="col-5" path="thoughts">My Thoughts:</form:label>
				<form:textarea class="col-10" path="thoughts" />
			</p>
			<input type="submit" value="Submit" class="col-3" />
		</form:form>
	</div>
</body>
</html>