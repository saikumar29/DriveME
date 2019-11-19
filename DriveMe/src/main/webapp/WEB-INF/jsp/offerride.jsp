<!DOCTYPE html>
<html lang="en">

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
	<!-- Navbar start -->
	<div id="nav-placeholder"></div>
	<script>
		$(function() {
			$("#nav-placeholder").load("navbar.html");
		});
	</script>
	<div class="container">
		<h2>Offer Ride</h2>
		<form action="/offerride" method="post">
			<div class="form-group">
				<label for="ride_start_point">Start Location:</label> <input
					type="text" class="form-control" id="ride_start_point"
					placeholder="Enter the Start location" name="ride_start_point" required>
			</div>
			<div class="form-group">
				<label for="ride_end_point">End Location:</label> <input type="text"
					class="form-control" id="ride_end_point"
					placeholder="Enter End Location" name="ride_end_point" required>
			</div>
			<div class="form-group">
				<label for="ride_start_date">Date:</label> <input type="date"
					class="form-control" id="ride_start_date" name="ride_start_date" required>
			</div>
			<div class="form-group">
				<label for="ride_start_time">Start Time:</label> <input type="time"
					class="form-control" id="ride_start_time" name="ride_start_time" required>
			</div>
			<div class="form-group">
				<label for="seats_offer">Capacity</label> <input type="number"
					class="form-control" placeholder="Enter Capacity" id="seats_offer"
					name="seats_offer" required>
			</div>

			<div class="form-group">
				<label for="amountPerSeat">Expected Amount</label> <input
					type="number" class="form-control" placeholder="Amount per seat"
					id="amountPerSeat" name="amountPerSeat" required>
			</div>

			<button type="submit" value="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<br>
</body>
</html>
