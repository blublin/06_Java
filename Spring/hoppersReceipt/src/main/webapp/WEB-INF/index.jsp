<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper's Receipt</title>
</head>
<body>
	<h1>Customer Name: ${name}</h1>
	<p> Item name: ${itemName }</p>
	<p>Price: $${price }</p>
	<p>Description: ${description }</p>
	<p>Vendor: ${vendor }</p>
</body>
</html>