<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<title>Offer Ride</title>
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
	<div id="nav-placeholder"></div>
	<script>
		$(function() {
			$("#nav-placeholder").load("navbar.html");
		});
	</script>
	<div class="container bg-1 text-center">
		<h2>Thank you for offering ride. This are the details of your
			ride:</h2>
		<div class="container-fluid bg-2" style="border: 1px solid #cecece;">
			<h3>Start Location:${OfferRide.ride_start_point}</h3>
			<h3>End Location:${OfferRide.ride_end_point}</h3>
			<h4>Date :${OfferRide.ride_start_date}</h4>
			
			<strong>Check you <a href="/user_profile">dashboard</a> for
				approving requesters
			</strong>

		</div>

	</div>
	<br>
	<div id="footer-placeholder"></div>
	<script>
		$(function() {
			$("#footer-placeholder").load("footer.html");
		});
	</script>
</body>
</html>