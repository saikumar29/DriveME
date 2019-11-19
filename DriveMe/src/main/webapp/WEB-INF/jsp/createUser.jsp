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
		
	
		/* function myFunction() {
		  alert("User saved successfully!");
		} */
		</script>
	<div class="container">
		<h2>Offer Ride</h2>
		<form action="/saveUser" method="post">
			<div class="form-group">
				<label for="firstName">First Name:</label> <input type="text"
					class="form-control" id="firstName" placeholder="First Name"
					name="firstName">
			</div>
			<div class="form-group">
				<label for="lastName">Last Name:</label> <input type="text"
					class="form-control" id="lastName" placeholder="Last Name"
					name="lastName">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="text"
					class="form-control" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="contactNumber">Contact Number:</label> <input
					type="number" class="form-control" id="contactNumber"
					placeholder="Contact Number" name="contatcNumber">
			</div>
			<div class="form-group">
				<label for="driving_license_number">Driving License Number</label> <input
					type="text" class="form-control"
					placeholder="Driving License Number" id="driving_license_number"
					name="driving_license_number">
			</div>

			<div class="form-group">
				<label for="usr_name">User Name:</label> <input type="text"
					class="form-control" id="usr_name" placeholder="User Name"
					name="usr_name">
			</div>


			<div class="form-group">
				<label for="usr_password">Password</label> <input type="password"
					class="form-control" placeholder="Password" id="usr_password"
					name="usr_password">
			</div>
			<button type="submit" value="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<!-- Footer -->
	<br>
	<!-- footer start -->
	<div id="footer-placeholder"></div>

	<!-- Footer -->
	<footer class="container-fluid bg-4 text-center">
		<p class="love">
			Owned <span class="glyphicon glyphicon-heart"></span> by SAIKUMAR
		</p>
	</footer>
	
</body>
</html>
