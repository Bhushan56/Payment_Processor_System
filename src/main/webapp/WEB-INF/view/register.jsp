<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="col d-flex justify-content-center">
		<br>
		<br>
		<div class="card" style="width: 20rem;">
			<h3 class="card-title">Register</h3>
			<div class="card-body">
				<form action="http://localhost:8080/register" method="post">
					<div class="form-group">
						<label for="name">Name</label> 
						<input type="text" class="form-control" id="name" name="name">
					</div>
					<div class="form-group">
						<label for="email">Email</label> 
						<input type="text" class="form-control" id="email" name="email" >
					</div>
					<div class="form-group">
						<label for="phoneNumber">Phone Number</label> 
						<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" >
					</div>
					<div class="form-group">
						<label for="address">Address</label> 
						<input type="text" class="form-control" id="address" name="address">
					</div>
					<div class="form-group">
						<label for="bic">Bank Code</label> 
						<input type="text" class="form-control" id="bic" name="bic">
					</div>
					<div class="form-group">
						<label for="accountNo">Account Number</label> 
						<input type="text" class="form-control" id="accountNo" name="accountNo">
					</div>
					
					<div class="form-group">
						<label for="amount">Initial Amount</label> 
						<input type="number" class="form-control" id="amount" name="amount" placeholder="Enter user ID">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter password">
					</div>
					
					 
					<button type="submit" class="btn btn-primary">Register</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>