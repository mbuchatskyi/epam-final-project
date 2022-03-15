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

<title>Change order status</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>

	<div class="reg">
		<c:if test="${ (empty orders) }">
			<script language="JavaScript" type="text/javascript">
				location = "welcome?command=order_list"
			</script>
		</c:if>
		<span style="text-align: center;">
			<h1>
				<a class="tour-list-link">All orders:</a>
			</h1>
			<div class = "leftingb">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Order id</th>
							<th scope="col">Total price</th>
							<th scope="col">Date of order</th>
							<th scope="col">Tour id</th>
							<th scope="col">User id</th>
							<th scope="col">Status</th>
							<th scope="col">Make order 'Paid'</th>
							<th scope="col">Make order 'Canceled'</th>
						</tr>
					</thead>
					<c:forEach var="orders" items="${orders}" varStatus="status">
						<tbody>
							<tr>
								<th scope="row">${orders.id}</th>
								<th scope="row">${orders.totalPrice}</th>
								<th scope="row">${orders.dateOfOrder}</th>
								<th scope="row">${orders.tourId}</th>
								<th scope="row">${orders.userId}</th>
								<th scope="row">${orders.orderStatusId}</th>
								<th scope="row">
									<form>
										<input type="hidden" name="command"
											value="order_status_update_paid" /> <input type="hidden"
											name="idorder" value="<c:out value="${ orders.id }" />" />
										<button class="btn btn-success">Change to 'Paid'</button>
									</form>
								</th>
								<th scope="row">
									<form>
										<input type="hidden" name="command"
											value="order_status_update_canceled" /> <input type="hidden"
											name="idorder" value="<c:out value="${ orders.id }" />" />
										<button class="btn btn-success">Change to 'Canceled'</button>
									</form>
								</th>
							</tr>
						</tbody>
					</c:forEach>
				</table>
		</span>
		</div>
		</div>
		<!-- Footer -->
	<%@ include file="/jsp/template/footer.jsp"%>
</body>
</html>