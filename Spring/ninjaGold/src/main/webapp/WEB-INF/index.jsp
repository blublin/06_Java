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
	<div class="container mx-auto p-3">
		<h3 class="text-center py-3">Your Gold: <c:out value="${gold}" /></h3>
		<div class="d-flex justify-content-between text-center py-3">
			
			<div class="container border border-3 border-dark d-flex flex-column p-2 col-2">
				<h4>Farm</h4>
				<p>(earns 10-20 gold)</p>
				<form action="/find/farm" method="post">
				 <input type="hidden" name="location" value="farm">
				<button class="btn btn-success">Find Gold!</button>
				</form>
			</div>
			
			<div class="container border border-3 border-dark d-flex flex-column p-2 col-2">
				<h4>Cave</h4>
				<p>(earns 5-10 gold)</p>
				<form action="/find/cave" method="post">
				<input type="hidden" name="location" value="cave">
				<button class="btn btn-success">Find Gold!</button>
				</form>
			</div>
			
			<div class="container border border-3 border-dark d-flex flex-column p-2 col-2">
				<h4>House</h4>
				<p>(earns 2-5 gold)</p>
				<form action="/find/house" method="post">
				<input type="hidden" name="location" value="house">
				<button class="btn btn-success">Find Gold!</button>
				</form>
			</div>
			
			<div class="container border border-3 border-dark d-flex flex-column p-2 col-2">
				<h4>Quest</h4>
				<p>(earns/loses 0-50 gold)</p>
				<form action="/find/quest" method="post">
				<input type="hidden" name="location" value="quest">
				<button class="btn btn-danger">Find Gold!</button>
				</form>
			</div>
			
		</div>
		
		<div class="row">
			<h3 class="text-center">Activities</h3>
			<div class="border border-3 text-center"
			style="max-height: 200px; overflow: auto;">
				<c:forEach items="${actions }" var="action">
					<p class=${action.contains('earned') ? "text-success" : "text-danger"}>
					<c:out value=
						"${action}"
					/>
					</p>
				</c:forEach>
			</div>
		
		</div>
	</div>
</body>
</html>