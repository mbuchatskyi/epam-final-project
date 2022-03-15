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

<title>Change discount</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>

	<div class="reg">
		<br> <span style="text-align: center;">
			<h2>Here you can change discount parameters</h2>
		</span> <br>
		<form id="registerform" style="width: 300px; margin: 0 auto"
			method="post" action="welcome">
			<input type="hidden" name="command" value="change_discount_manager" />
			<div class="form-group">
				<label class="control-label" for="name">Please, enter step
					of discount</label>
				<div class="controls">
					<input type="text" pattern="([0-9]){0,2}"
						data-validation-pattern-message="Incorrect id."
						class="form-control" id="step" name="step" required>
					<p style="font-size: 0.8em;">Can contain English letters or
						numbers, without spaces. Min. length: 3, max: 16.</p>
				</div>
				<div class="form-group">
					<label class="control-label" for="name">Please, enter max
						of discount</label>
					<div class="controls">
						<input type="text" pattern="([0-9]){0,3}"
							data-validation-pattern-message="Incorrect id."
							class="form-control" id="max" name="max" required>
						<p style="font-size: 0.8em;">Can contain English letters or
							numbers, without spaces. Min. length: 3, max: 16.</p>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
	</div>
	<!-- Footer -->
	<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>
