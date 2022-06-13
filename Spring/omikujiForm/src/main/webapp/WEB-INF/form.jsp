<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
</head>
<body>
	<div class="col-6 mx-auto my-5 text-center">
		<form action="/processForm" method="post">
			<label class="form-label">Pick any number from 5 to 25</label>
			<select class="form-control" name="selNum">
				<% for (int i = 5; i <= 25; i++) { %>
					<option value="<%=i%>"><%=i%></option>
				<% } %>
			</select>
			
			<label class="form-label">Enter the name of any city</label>
			<input class="form-control" type="text" name="city" />
			
			<label class="form-label"> Enter the name of any real person</label>
			<input class="form-control" type="text" name="person" />
			
			<label class="form-label">Enter professional endeavor or hobby</label>
			<input class="form-control" type="text" name="endeavor" />
			
			<label class="form-label">Enter any living thing</label>
			<input class="form-control" type="text" name="livingThing" />
			
			<label class="form-label">Say something nice to someone</label>
			<textarea class="form-control" name="nice" cols="30" rows="5"></textarea>
			
			<label  class="form-label"> Send and show a friend </label>
			<button class="btn btn-primary">Send</button>
		</form>
	</div>
</body>
</html>