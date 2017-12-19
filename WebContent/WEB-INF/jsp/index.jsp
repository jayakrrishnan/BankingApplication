<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BankingApp</title>
</head>
<body
	style="background-image: url('resources/img/1.jpg'); color: #efd6e7;">
	<div class="row">

		<form action="login" method="post" class="form-group"
			style="margin-left: 20%; margin-top: 10px; width: 1200px">

			<label class="col-sm-4 ">Username:</label>
			 <label style="margin-left: 50px;">Password:</label> <br> 
			 <input class="col-sm-4 " type="text" name="userName" placeholder="userName"
				style="float: left" required="required" />
			 <input class="col-sm-4" type="password" name="passWord" value="" placeholder="passWord"
				style="margin-left: 50px;" required="required" /> 
			<input class="col-sm-1 btn btn-primary" type="submit" value="login"
				style="margin-left: 20px;" />

		</form>
		<div style="margin-left: 20%">
			<c:out value="${error}"></c:out>
		</div>
	</div>
	<h1 style="margin-left: 40%; margin-top: 65px">Registration</h1>
	<br>
	<div style="margin-left: 20%">
			<c:out value="${success}"></c:out>
	</div>
	<br>
	<div class="row" style="padding-left: 20px; margin-left: 15%;">

		<form:form action="register" method="post" commandName="command2"
			class="form-group">
			<div style="float: left; padding-left: 40px;">
				<label>Username:</label> <input class="col form-control" type="text"
					name="userName" value="" placeholder="userName" required /> <label>Password:</label>
				<input class="col form-control" type="password" name="passWord"
					placeholder="passWord" required /> <br>
			</div>
			<div style="float: left; padding-left: 100px;">
				<label>CustomerName:</label>
				<form:input class="col form-control" type="text" path="customerName"
					value="" required="required" placeholder="customerName" />

				<label>AddressLine1:</label>
				<form:input class="col form-control" type="text" path="addressLine1"
					value="" placeholder="addressLine1" required="required" />

				<label>AddressLine2:</label>
				<form:input class="col form-control" type="text" path="addressLine2"
					value="" placeholder="addressLine2" required="required" />

				<label>city:</label>
				<form:input class="col form-control" type="text" path="city"
					value="" placeholder="city" required="required" />

				<label>zip:</label>
				<form:input class="col form-control" type="number" path="zipCode"
					value="" placeholder="zip" required="required" />

				<label>Email:</label>
				<form:input class="col form-control" type="email" path="email"
					value="" placeholder="email" required="required" />
				<label>phone:</label>
				<form:input class="col form-control" type="number"
					path="mobileNumber" value="" placeholder="mobileNumber"
					required="required" />

			</div>
			<div style="float: left; padding-left: 100px;">
				<label>BranchName:</label>
				<form:input class="col form-control" type="text" path="branchName"
					value="" placeholder="branchName" required="required" />
				<label>AccountNo:</label>
				<form:input class="col form-control" type="number"
					path="accountNumber" value="" placeholder="accountNumber"
					required="required" />
				<label>AccountType:</label>
				<form:input class="col form-control" type="text" path="accountType"
					value="" placeholder="accountType" required="required" />
				<label>Deposit:</label>
				<form:input class="col form-control" type="text" path="balance"
					value="" placeholder="balance" />

			</div>



			<br>
			<input class="col btn btn-primary" style="margin-top: 20px"
				type="submit" value="Register" />
			<br>
		
		
		

		</form:form>
		

	</div>


</body>
</html>