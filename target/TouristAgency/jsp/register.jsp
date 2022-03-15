<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
<title>Registration</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">

<link href="/css/mystyles.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/jsp/template/header.jsp"%>

	<div class="reg">
		<br> <span style="text-align: center;">
			<h1>Registration</h1>
		</span> <br>
		<form id="registerform" style="width: 300px; margin: 0 auto"
			method="post" action="welcome">
			<input type="hidden" name="command" value="register" />
			<div class="form-group">
				<label class="control-label" for="login">Login*</label>
				<div class="controls">

					<input type="text" pattern="([A-ZА-Яa-zа-я0-9_-]){3,16}"
						data-validation-pattern-message="Incorrect login"
						class="form-control" id="login" name="login" required>
					<p style="font-size: 0.8em;">Can contain English letters or
						numbers, without spaces. Min. length: 3, max: 16.</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="password">Password*</label>
				<div class="controls">
					<input type="password" pattern="([A-ZА-Яa-zа-я0-9_-]){8,20}"
						data-validation-pattern-message="Incorrect password"
						class="form-control" id="password" name="password" required>
					<p style="font-size: 0.8em;">Can contain English letters or
						numbers, without spaces. Min. length: 8, max: 20.</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="email">Email*</label>
				<div class="controls">
					<input type="email" data-validation-email-message="Incorrect email"
						class="form-control" id="email" name="email" required>
					<p style="font-size: 0.8em;">An email address must contain a
						single @</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="name">Name*</label>
				<div class="controls">
					<input type="text" pattern="([A-ZА-Яa-zа-я]){2,25}"
						data-validation-pattern-message="Incorrect name"
						class="form-control" id="first_name" name="first_name" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="surname">Surname</label>
				<div class="controls">
					<input type="text" pattern="([A-ZА-Яa-zа-я]){2,25}"
						data-validation-pattern-message="Incorrect surname"
						class="form-control" id="last_name" name="last_name" required>
				</div>
			</div>
			<c:choose>
				<c:when test="${ not empty errorRegisterPassMessage }">
					<br />
					<span style="color: #ff0000;">${errorRegisterPassMessage}</span>
					<br />
					<br />
				</c:when>
				<c:otherwise>
					<br />
				</c:otherwise>
				

			</c:choose>
			<button id="sub" type="submit" class="btn btn-success">Create!</button>
		</form>
	</div>
	<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>