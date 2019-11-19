<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Find Ride</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- Navbar start -->
	<div id="nav-placeholder"></div>
	<script>
		$(function() {
			$("#nav-placeholder").load("navbar.html");
		});
	</script>
	<div class="container">
		<h2>Find Ride</h2>
		<form action="/searchRide" method="post">
			<div class="form-group">
				<label for=StartLocation>Start Point:</label>
				<c:if test="${empty ride_start_point}">
					<input type="text" class="form-control" id="StartLocation"
						placeholder="Enter the Start location" name="ride_start_point">
				</c:if>
				<c:if test="${not empty ride_start_point}">${ride_start_point}</c:if>
			</div>
			<div class="form-group">
				<label for="EndLocation">Drop Location:</label>
				<c:if test="${empty ride_end_point}">
					<input type="text" class="form-control" id="EndLocation"
						placeholder="Enter End Location" name="ride_end_point">
				</c:if>

				<c:if test="${not empty ride_end_point}">${ride_end_point}</c:if>
			</div>
			<div class="form-group">
				<label for="date">Date:</label>
				<c:if test="${empty ride_start_date}">
					<input type="date" class="form-control" id="date"
						name="ride_start_date">
				</c:if>
				<c:if test="${not empty ride_start_date}">${ride_start_date}</c:if>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


		<div class="container">
			<c:choose>
				<c:when test="${empty offerRideList && not empty ride_start_date}  "> No rides available for your request</c:when>
				<c:otherwise>
					<h2>Available rides :</h2>
					<ul>
						<c:forEach var="listValue" items="${offerRideList}">

							<li><strong>Owner Name:</strong>
								${listValue.or_user_id.firstName}
								${listValue.or_user_id.lastName} <strong>Start Time: </strong>${listValue.ride_start_time}
								<strong>Contact Number:</strong>${listValue.or_user_id.contatcNumber}
								<strong>Seats Available:</strong>${listValue.seats_available} <a
								class="btn btn-danger"
								href="/acceptRide?or_id=${listValue.or_id}">Accept</a></li>

						</c:forEach>
					</ul>
				</c:otherwise>
			</c:choose>

		</div>
	</div>


	<br>

</body>
</html>
