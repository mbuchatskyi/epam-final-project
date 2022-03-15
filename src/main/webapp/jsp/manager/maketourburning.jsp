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

<title>Make tour burning</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>

	<div class="reg">
		<c:if test="${ (empty tours) }">
			<script language="JavaScript" type="text/javascript">
				location = "welcome?command=tour_list_for_manager"
			</script>
		</c:if>
		<span style="text-align: center;">
			<h1>
				<a class="tour-list-link">All tours:</a>
			</h1>
			<div class="leftingb">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Tour id</th>
							<th scope="col">Name</th>
							<th scope="col">Price</th>
							<th scope="col">People amount</th>
							<th scope="col">Hotel id</th>
							<th scope="col">Tour type id</th>
							<th scope="col">Burning status</th>
							<th scope="col">Change tour to burning status</th>
						</tr>
					</thead>
					<c:forEach var="tours" items="${tours}" varStatus="status">
						<c:choose>
						<c:when test= "${ tours.isDeleted == false}">
						<tbody>
							<tr>
								<th scope="row">${tours.id}</th>
								<th scope="row">${tours.name}</th>
								<th scope="row">${tours.price}</th>
								<th scope="row">${tours.peopleAmount}</th>
								<th scope="row">${tours.hotelId}</th>
								<th scope="row">${tours.tourTypeId}</th>
								<th scope="row">${tours.isBurning}</th>
								<th scope="row">
									<form>
										<input type="hidden" name="command"
											value="burning_tour" /> <input type="hidden"
											name="tourid" value="<c:out value="${ tours.id }" />" />

										<button class="btn btn-success">Make tour burning</button>
									</form>
								</th>
						</tbody>
						</c:when>
						</c:choose>
					</c:forEach>
				</table>
				</div>
		</span>
		<!-- Footer -->
	<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>