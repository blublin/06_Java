<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
</head>
<body>
	<h1 class="text-primary text-center">Fruits Store</h1>
	<div class="col-6 m-auto border border-5 border-success">
		<table class="table table-sm table-border text-center">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fruitsArray}" var="item">
					<tr>
						<!-- Using getters and setters cause F*** JSP/JSTL auto interpretting, let me do the explicit work!! -->
						<td class="m-auto">${item.getName() }</td>
						<td class="m-auto">${item.getPrice() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>