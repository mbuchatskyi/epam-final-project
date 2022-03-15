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

<title>Home</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>
	<div class="reg">
		<c:if test="${ (empty tours) }">
			<script language="JavaScript" type="text/javascript">
				location = "welcome?command=tour_list"
			</script>
		</c:if>
		<span style="text-align: center;">
			<h1> <a class="tour-list-link">Our tours</a> </h1>
		</span>
		<div class="leftingc">
		<c:forEach var="tours" items="${tours}" varStatus="status">
			<c:choose>
				<c:when test="${ tours.isDeleted == false}">
					<div class="card" style="width: 800px;">
						<div class="card-body">
							<span style="text-align: center;">
								<h5 class="card-title">
									<c:out value="${ tours.name }" />
									<c:choose>
										<c:when test="${ tours.isBurning == true}">
											<img src="./images/fire.png" width="20" height="20">
											<img src="./images/fire.png" width="20" height="20">
											<img src="./images/fire.png" width="20" height="20">
										</c:when>
									</c:choose>
								</h5>
							</span>
							<h5>
								<c:out value="${ tours.description} " />
							</h5>
							<p class="card-text">
								<br> This tour is intended for</b>
								<c:out value="${ tours.peopleAmount } people." />
							<p>
							<p class="card-text">
								<b> Price:</b>
								<c:out value="${ tours.price } $" />
							<p>
								<c:choose>
									<c:when test="${ not empty user }">
										<c:choose>
											<c:when test="${ blocked == false }">
												<p class="card-text">
													<b> Your discount: </b>
													<c:out value="${ discount } %" />
												</p>
												<form class="form-horizontal" id="orderform" method="post"
													action="welcome">
													<input type="hidden" name="command" value="order_tour" />
													<input type="hidden" name="iduser"
														value="<c:out value="${ id }" />" /> <input type="hidden"
														name="idtour" value="<c:out value="${ tours.id }" />" />
													<input type="hidden" name="price"
														value="<c:out value="${ tours.price }" />" />
													<button class="btn btn-success">Order now</button>
												</form>
											</c:when>
										</c:choose>
										<c:choose>
											<c:when test="${ blocked == true }">
												<p class="card-text font-col">
													<span style="color: #ff0000;"> <b> You can't do
															order. You was banned by admin. Contact us, please, if
															you want to know ban's reason.</b>
													</span>
												</p>
											</c:when>
										</c:choose>
									</c:when>
								</c:choose>
							</p>
						</div>
						</div>
						<br>
				</c:when>
			</c:choose>
		</c:forEach>
		</div>
		</div>
	<!-- Footer -->
	<%@ include file="/jsp/template/footer.jsp"%>
</body>