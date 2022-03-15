<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/mystyles.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" >Tourist Agency</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="welcome?command=tour_list">Tour List<span
				class="sr-only">(current)</span></a> 
			<c:choose>
				<c:when test="${ not empty user }">
					<c:choose>
						<c:when test="${ role==3 }">
							<a class="nav-item nav-link" href="welcome?command=forward&page=admin">Create tour</a>
							<a class="nav-item nav-link" href="welcome?command=forward&page=deletetour">Delete tour</a>
							<a class="nav-item nav-link" href="welcome?command=forward&page=block">Block user</a>
						</c:when>
						<c:when test="${ role==2 }">
							<a class="nav-item nav-link" href="welcome?command=forward&page=orders_list">Edit order status</a>
							<a class="nav-item nav-link" href="welcome?command=forward&page=discount">Edit discount</a>
							<a class="nav-item nav-link" href="welcome?command=forward&page=burning">Burning tour</a>
						</c:when>
					</c:choose>
					<a class="header nav-item nav-link">Welcome, ${user}</a>
					<a class="nav-item nav-link" href="welcome?command=logout">Log out</a>
				</c:when>
				<c:otherwise>
					<a class="header nav-item nav-link" href="welcome?command=forward&page=login">Log in</a>
					<a class="nav-item nav-link" href="welcome?command=forward&page=register">Sign Up</a>
				</c:otherwise>
				
				
			</c:choose>
			
		</div>
	</div>
</nav>

<hr class="reg">
</body>



