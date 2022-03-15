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

<title>Create tour</title>
</head>

<body>
	<!-- Header -->
	<%@ include file="/jsp/template/header.jsp"%>

    <div class="reg"> <br>
    <span style="text-align: center;">
    <h2>Here you can create new tour </h2>
    </span> <br>
    <form id="registerform" style="width: 300px; margin: 0 auto" method="post" action="welcome">
        <input type="hidden" name="command" value="create_tour" />
        <div class="form-group">
            <label class="control-label" for="name">Name</label>
            <div class="controls">
            <input type="text" pattern="([A-ZА-Яa-zа-я_-]){3,16}" data-validation-pattern-message="Incorrect name"  class="form-control" id="name" name="name" required>
            <p style="font-size: 0.8em;">Can contain English letters. Min. length: 3, max: 16.</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label" >Description</label>
            <div class="controls">
            <input type="text" pattern="([A-ZА-Яa-zа-я0-9_-.]){5,20}" class="form-control" id="description" name="description" required>
             <p style="font-size: 0.8em;">Can contain English letters or numbers, without spaces. Min. length: 5, max: 20.</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label" for="price">Price</label>
            <div class="controls">
                <input type="text" pattern="([0-9]){1,5}" data-validation-email-message="Incorrect price" class="form-control" id="price" name="price" required>
             <p style="font-size: 0.8em;"></p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label" for="name">People amount</label>
            <div class="controls">
            <input type="text" pattern="([0-9]){1}" data-validation-pattern-message="Incorrect people amount" class="form-control" id="people_amount" name="people_amount" required> 
            </div>
        </div>
        <div class="form-group">
            <label class="control-label" for="surname">Hotel type ID</label>
            <div class="controls">
            <input type="text" pattern="([0-9]){1,25}" data-validation-pattern-message="Incorrect hotel type id" class="form-control" id="hotel_id" name="hotel_id" required>
            </div>
         </div>
             <div class="form-group">
            <label class="control-label" for="surname">Tour type ID</label>
            <div class="controls">
            <input type="text" pattern="([0-9]){1,25}" data-validation-pattern-message="Incorrect tour type id" class="form-control" id="tour_type_id" name="tour_type_id" required>
            </div>
        </div>
        <c:choose>
            <c:when test="${ not empty errorRegisterPassMessage }">
                <br/>
                <span style="color: #ff0000;">${errorRegisterPassMessage}</span>
                <br/>
                <br/>
            </c:when>
            <c:otherwise>
                <br/>
            </c:otherwise>
        </c:choose>
        <button id="sub" type="submit" class="btn btn-success">Create tour</button>
    </form>
</div>

<%@ include file="/jsp/template/footer.jsp"%>
</body>