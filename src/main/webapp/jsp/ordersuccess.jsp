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

<title>Thank you</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>
	<div class="reg">
		<br>
		<form id="loginform" style="width: 600px; margin: 0 auto"
			method="post" action="welcome">
			<input type="hidden" name="command" value="change_discount" /> <span
				style="text-align: center;">
				<div>
					<h1>Thank you for the interest!</h1>
					<br>
					<h6>We are sorry, but in this time we can't hold a meeting
						with you in our office.</h6>
					<br> <br>
					<h6>Our manager will contact you for an hour in order to set
						the time of the online-call in Google Meets. Please, check your
						e-mail.</h6>
					<br> <br> <br>
					<h3>Pay your attention! There is a system of discounts.</h3>
					<br>
					<h6>Now your discount is ${discount}%. But after every order
						it will be increased on ${step}%.</h6>
					<br>
					<h6>Moreover, the maximum possible discount is ${max}%.</h6>
					<br>
					<h6>Get your bonus and you will be returned to the home page.
					</h6>
					<br>
					<h6>Thank you for choosing our company!</h6>
					<br> 
				</div>
			</span>
			<div class="lefting">
				<button class="btn btn-success">Take your bonus</button>
			</div>
		</form>
		<%@ include file="/jsp/template/footer.jsp"%>
	</div>
</body>