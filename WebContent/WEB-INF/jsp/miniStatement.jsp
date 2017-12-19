<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini Statement</title>
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
	<h3 style="text-align: center; margin-top: 20px">Transaction
		History</h3>

	<table class="table table-dark table-hover">
		<tr>
			<th>Transaction Id:</th>
			<th>To Account:</th>

			<th>Amount:</th>
			<th>Date:</th>
		</tr>

		<c:forEach items="${txs }" var="tx">
			<tr>
				<td><c:out value="${tx.transactionId}"></c:out></td>

				<td><c:out value="${tx.toAccount}"></c:out></td>
				<td><c:out value="${tx.amount}"></c:out></td>
				<td><c:out value="${tx.date}"></c:out></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>