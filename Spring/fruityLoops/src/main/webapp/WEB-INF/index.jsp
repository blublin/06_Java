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
	<h1 class="text-primary">Fruits Store</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${fruitsArray}" var="item">
				<tr>
					<td>${item.getName() }</td>
					<td>${item.getPrice() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>