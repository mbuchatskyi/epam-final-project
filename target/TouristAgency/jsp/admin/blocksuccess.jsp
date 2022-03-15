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
		<br>
		<div class="lefting">
			<c:choose>
				<c:when test="${ not empty err }">
					<br />
					<span style="color: #ff0000;">User with entered login
						doesn't exist. The command didn't execute.</span>
					<br />
					<br />
				</c:when>
				<c:when test="${ not empty isalreadyblockederror }">
					<br />
					<span style="color: #ff0000;">User with entered login
						is already banned. The command didn't execute. </span>
					<br />
					<br />
				</c:when>
				<c:when test="${ not empty isalreadyunblockederror }">
					<br />
					<span style="color: #ff0000;">User with entered login
						isn't banned. The command didn't execute. </span>
					<br />
					<br />
				</c:when>
				<c:otherwise>
					<span style="color: #ff0000;">The command successfully executed.</span>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>
