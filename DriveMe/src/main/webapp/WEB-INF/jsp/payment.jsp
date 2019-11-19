<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>Payment</title>
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
		<c:if test="${not empty payment.amount_paid}">
			<h1 style="color: green">Payment Done :$ ${payment.amount_paid}</h1>
			<a class="btn btn-default" href="/user_profile">Go Back</a>
		</c:if>


		<h2>Please make a Payment</h2>

		<form action="/savePayment" method="post">
			<div class="col-sm-3">
				<div class="form-group">
					<p>Amount to be Pay</p>
					<input type="text" class="form-control" id="amount_paid"
						name="amount_paid"> <input type="hidden"
						class="form-control" id="payment_map_rr" value=${Requester_Id }
						name="payment_map_rr">


				</div>

				<label for="fname">Accepted Cards</label> <img
					src="http://www.pngmart.com/files/3/Major-Credit-Card-Logo-PNG-File.png"
					width="150px">

				<div class="form-group">
					<label for="noc">Name on Card:</label> <input type="text"
						class="form-control" id="noc" required>
				</div>
				<div class="form-group">
					<label for="cardNum"> Credit Card Number:</label> <input
						type="number" class="form-control" id="cardNum" required>
				</div>
				<div class="form-group">
					<label for="cardNum"> Exp MM/YY:</label> <input type="text"
						class="form-control" id="exp" placeholder="MM/YY" required>
				</div>
				<div class="form-group">
					<label for="ccv"> CCV:</label> <input type="text"
						class="form-control" id="ccv" placeholder="" required>
				</div>
			</div>
	</div>
	<div style="padding-left: 150px">
		<button type="submit" value="submit" class="btn btn-warning">Pay
			Now</button>
	</div>
	</form>


	</div>
	<br>
	<br>

</body>