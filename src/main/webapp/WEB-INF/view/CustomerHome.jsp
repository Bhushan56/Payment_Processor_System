<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="col d-flex justify-content-center">
		<br>
		<br>
		<div class="card" style="width: 20rem;">
			<h3 class="card-title">Pay here</h3>
			<div class="card-body">
				<form action="http://localhost:8080/pay" method="post">
					<div class="form-group">
						<label for="senderUserId">Sender User ID</label> 
						<input type="text" class="form-control" id="senderUserId" name="senderUserId" value="${user.userId}" readonly>
					</div>
					<div class="form-group">
						<label for="senderAccountNumber">Sender Account Number</label> 
						<input type="text" class="form-control" id="senderAccountNumber" name="senderAccountNumber" value="${user.accountNumber}" readonly>
					</div>
					<div class="form-group">
						<label for="senderName">Sender Name</label> 
						<input type="text" class="form-control" id="senderName" name="senderName" value="${user.name}" readonly>
					</div>
					<div class="form-group">
						<label for="senderBankCode">Sender Bank Code</label> 
						<input type="text" class="form-control" id="senderBankCode" name="senderBankCode" value="${user.bic}" readonly>
					</div>
					
					<div class="form-group">
						<label for="beneficiaryUserId">Receiver User ID</label> 
						<input type="number" class="form-control" id="userId" name="beneficiaryUserId" placeholder="Enter user ID">
					</div>
					<div class="form-group">
						<label for="beneficiaryName">Receiver's Name</label> <input type="text"
							class="form-control" id="beneficiaryName" name="beneficiaryName"
							placeholder="Enter name">
					</div>
					
					<div class="form-group">
						<label for="mobileNumber">Receiver Mobile Number</label> <input type="number"
							class="form-control" id="receiverMobileNumber" name="receiverMobileNumber"
							placeholder="Enter mobile number">
					</div>
					<div class="form-group">
						<label for="bic">Receiver Bank Code</label> <input type="text"
							class="form-control" id="bic" name="bic"
							placeholder="Enter Bank Code">
					</div>
					<div class="form-group">
						<label for="beneficiaryAccountNumber">Receiver Account number</label> 
						<input type="text" class="form-control" id="beneficiaryAccountNumber"
							name="beneficiaryAccountNumber" placeholder="Enter Account Number">
					</div>
					<div class="form-group">
						<label for="amount">Enter Amount</label> <input type="text"
							class="form-control" id="amount" name="amount"
							placeholder="Enter Account Number">
					</div>
					<button type="submit" class="btn btn-primary">Pay</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>