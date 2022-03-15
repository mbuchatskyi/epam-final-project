<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- My CSS styles -->
<link href="/css/mystyles.css" rel="stylesheet">

<title>Login</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>

	<div class="reg">
		<br> <span style="text-align: center;">
			<div>
				<h1>Hello!</h1>
				<h3>
					Sign in to the site or create account here -> <a
						href="welcome?command=forward&page=register">Sign Up</a>
				</h3>
				<br>
				<h7> *The unregistered users can only see the list of tours
				which we offer. If you want to make order you must be registered.</h7>
				<br>
				<h7>The registrating does not take longer than 1-2 minutes.</h7>
			</div>
		</span> <br>
		<form id="loginform" style="width: 300px; margin: 0 auto"
			method="post" action="welcome">
			<input type="hidden" name="command" value="login" />
			<div class="form-group">
				<label class="control-label" for="login">Login</label>
				<div class="controls">
					<input type="text" pattern="([A-ZА-Яa-zа-я0-9_-]){3,16}"
						data-validation-pattern-message="Incorrect login"
						class="form-control" id="login" name="login" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" pattern="([A-ZА-Яa-zа-я0-9_-]){5,20}"
						data-validation-pattern-message="Incorrect password"
						class="form-control" id="password" name="password" required>
				</div>
			</div>
			<c:choose>
				<c:when test="${ not empty errorLoginPassMessage }">
					<br />
					<span style="color: #ff0000;">${errorLoginPassMessage}</span>
					<br />
					<br />
				</c:when>
				<c:otherwise>
					<br />
				</c:otherwise>
			</c:choose>
			<button type="submit" class="btn btn-success">Submit</button>
			<br> <br> <br>
		</form>
	</div>
	<!-- Footer -->
	<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>