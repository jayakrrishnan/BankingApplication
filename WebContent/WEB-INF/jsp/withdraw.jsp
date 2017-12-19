<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('resources/img/8.jpg');">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">
			<pre><div
				style="color: white; font-family: cursive; font-style: oblique; font-size: 20px">
				User:${sessionScope.user.getUserName()}   	Balance:${sessionScope.customerUser.getBalance()}
			</div></pre>
		</a>
		<ul class="navbar-nav">
			<li class="nav-item">
				<form class="nav-link" action="home" method="get">
					<input type="submit" value="Home">
				</form>
			</li>
			<li class="nav-item" style="padding-left: 450px">
				<form class="nav-link" action="logout" method="get">
					<input type="submit" value="Logout" class="btn btn-danger">
				</form>
			</li>
		</ul>

	</nav>
	<h3 style="text-align: center; margin-top: 20px">WithDraw amount</h3>
	<div class="row" style="margin-left: 15%; margin-top: 10%">
		<form action="withdraw" method="post" class="form-group"
			style="margin-left: 20%; margin-top: 10px; width: 1200px">

			<label class="col-sm-2 ">Amount:</label> <input type="text"
				name="amount" required="required" class="col-sm-4 "><br>

			<label class="col-sm-2 ">Password:</label> <input type="password"
				name="passWord" required="required" class="col-sm-4 "><br>

			<input type="submit" value="withdraw"
				class="col-sm-3 btn btn-primary"
				style="margin-left: 200px; margin-top: 20px">

		</form>
		<div style="margin-left: 20%">
			<c:out value="${msg}"></c:out>
		</div>
	</div>




</body>
</html>