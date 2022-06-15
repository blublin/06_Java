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
<title>Expense Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container w-75 mx-auto">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-center">Expense Details</h1>
			<a class="display-5" href="/">Go Home</a>
		</div>
		<table class="table table-borderless">
			<tbody>
				<tr class="d-flex justify-content-center">
					<th class="col-3 text-end">Expense name:</th>
					<td class="col-4">${exp.getName() }</td>
				</tr>

				<tr class="d-flex justify-content-center">
					<th class="col-3 text-end">Description:</th>
					<td class="col-4">${exp.getDescription() }</td>
				</tr>

				<tr class="d-flex justify-content-center">
					<th class="col-3 text-end">Vendor:</th>
					<td class="col-4">${exp.getVendor() }</td>
				</tr>

				<tr class="d-flex justify-content-center">
					<th class="col-3 text-end">Amount Spent:</th>
					<td class="col-4">$${exp.getAmount() }</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>