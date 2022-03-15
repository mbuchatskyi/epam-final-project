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

<title>Block user</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>
	<div class="reg">
		<br> <span style="text-align: center;">
			<h2>Here you can block user</h2>
		</span> <br>
		<form id="registerform" style="width: 300px; margin: 0 auto"
			method="post" action="welcome">
			<input type="hidden" name="command" value="block_user" />

			<div class="form-group">
				<label class="control-label" for="name">Please, enter user
					login you want to ban</label>
				<div class="controls">
					<input type="text" pattern="([A-ZА-Яa-zа-я0-9_-]){3,16}"
						data-validation-pattern-message="Incorrect id."
						class="form-control" id="login" name="login" required>
					<p style="font-size: 0.8em;">Can contain English letters or
						numbers, without spaces. Min. length: 3, max: 16.</p>
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
				<button id="sub" type="submit" class="btn btn-success">Block
					user</button>
			</div>
		</form>

		<div class="reg">
			<br> <span style="text-align: center;">
				<h2>Here you can unblock user</h2>
			</span> <br>
			<form id="registerform" style="width: 300px; margin: 0 auto"
				method="post" action="welcome">
				<input type="hidden" name="command" value="unblock_user" />

				<div class="form-group">
					<label class="control-label" for="name">Please, enter user
						login you want to unban</label>
					<div class="controls">
						<input type="text" pattern="([A-ZА-Яa-zа-я0-9_-]){3,16}"
							data-validation-pattern-message="Incorrect id."
							class="form-control" id="login" name="login" required>
						<p style="font-size: 0.8em;">Can contain English letters or
							numbers, without spaces. Min. length: 3, max: 16.</p>
					</div>
					<button id="sub" type="submit" class="btn btn-success">Unblock
						user</button>
				</div>
			</form>
		</div>
		<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>
