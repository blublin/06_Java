<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Counter Check</title>
</head>
<body>
	You have visited <a href="http://localhost:8080">Counter Website</a> ${ sessionScope.count != null ? sessionScope.count : "0"} times.
	<br />
	<a href="http://localhost:8080">Test another visit?</a>
	<br />
	<a href="http://localhost:8080/double">Try double or double</a>
	<br />
	<a href="reset" class="btn btn-primary">Reset</a>
</body>
</html>