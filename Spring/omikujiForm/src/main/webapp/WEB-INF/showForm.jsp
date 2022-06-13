<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="text-center">Here's Your Omikuji!</h1>
	<div class="col-6 mx-auto my-3 text-center bg-primary border border-3 border-dark">
		<p class="col-4 text-center mx-auto">
		In <c:out value="${selNum}" /> years, you will
		live in <c:out value="${city}" /> with
		<c:out value="${person }" /> as your
		roommate, selling
		<c:out value="${endeavor }" /> for a living.
		The next time you
		see a <c:out value="${livingThing }" />, you will
		have good luck.
		Also, <c:out value="${nice }" />
		</p>
	</div>
	
	<a href="/" class="btn btn-primary mx-auto">Go Back</a>
</body>
</html>