<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BankingApp</title>
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
	
	<div style="margin-left: 20%;font-size: 20px;margin-top: 50px">
			<c:out value="${msg}"></c:out>
	</div>
	
	<div class="row" style="margin-left: 25%; margin-top: 10%">
	
		<form action="withdraw" method="get" class="form-group"
			style="float: left; width: 200px" >

			<input type="submit" value="Withdrawal"
				class="col-lg-10 btn btn-primary" style="height: 90px;" >
		</form>
	
		<br>
		<form action="transfer" method="get" class="form-group"
			style="float: left; width: 200px;margin-left: 60px">

			<input type="submit" value="Transfer"
				class="col-lg-10 btn btn-primary" style="height: 90px;"> <br>
		</form>

		<form action="statement" method="get" class="form-group"
			style="float: left; width: 200px;margin-left: 60px">

			<input type="submit" value="MiniStatement"
				class="col-lg-10 btn btn-primary" style="height: 90px;"> <br>
		</form>
	</div>
	<!-- <form action="Updation" method="post" class="form-group"
			style="margin-left: 20%; margin-top: 10px; width: 1200px">
<label>Update Details</label>
<input type="submit" value="submit" class="col-sm-1 btn btn-primary"
				style="margin-left: 20px;">
<br>
</form> -->

	<!-- <label>ConfirmPassWord</label>
<input type="password" name="password"/>
<label>Amount</label>
<input type="text" name="amount"/>
<input type="submit" value="submit"/> -->


	</div>
</body>
</html>