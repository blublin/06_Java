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
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container p-3 mx-auto">
		<h1 class="text-center">Save Travels</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<td>Expense</td>
					<td>Vendor</td>
					<td>Amount</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expenses}" var="e">
					<tr>
						<td>${e.getName() }</td>
						<td>${e.getVendor() }</td>
						<td>$${e.getAmount() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <br />
		<div class="container w-75">
			<h1 class="text-center">Add an expense:</h1>
			<form:form action="/" method="post" modelAttribute="expense"
				class="d-flex flex-column align-items-center border border-3 border-dark">
				<p>
					<form:errors path="name" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="name">Expense Name:</form:label>
					<form:input class="col-12" path="name" />
				</p>

				<p>
					<form:errors path="vendor" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="vendor">Vendor:</form:label>
					<form:textarea class="col-12" path="vendor" />
				</p>

				<p>
					<form:errors path="amount" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="amount">Amount:</form:label>
					<form:input class="col-12" path="amount" />
				</p>

				<p>
					<form:errors path="description" />
				</p>
				<p class="d-flex">
					<form:label class="col-5" path="description">Description:</form:label>
					<form:textarea class="col-12" path="description" />
				</p>
				<input type="submit" value="Submit" class="col-3" />
			</form:form>
		</div>

	</div>
</body>
</html>