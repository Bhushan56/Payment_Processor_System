<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<title>Insert title here</title>
	<style>
		.subheader-align{
			text-align:right;
			font-weight:700;
		}
		.card{
			width:100%;
		}
		.data-header-align{
			text-align:left;
		}
		.f-align{
			padding-left:40%;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<a class="mr-2" onClick="showPaymentStatusPage()" href="#paymentStatus">View Customer Payment</a>
			<a onClick="showBankPaymentPage()" href="#paymentTransfer">Send Money</a>
		</div>
		
		<div class="row" id="paymentStatus">
				<c:forEach var="payment" items="${pendingTransaction}">
					<div class="card mb-5">
						<div class="card-header text-center font-weight-bold"> ${payment.orderingCustomer.split(",")[0]}(${payment.orderingCustomer.split(",")[1]}) </div>
						<div class="card-body">
							<div class="row">
								<div class="subheader-align col-lg-6">
									(20)Sender's Reference Number:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.senderReference}
								</div>
							</div>
							<div class="row">
								<div class="subheader-align col-lg-6">
									(32a)Date:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.date }
								</div>
							</div>
							<div class="row">
								<div class="subheader-align col-lg-6">
									(32a)Amount:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.amount }
								</div>
							</div>
							<div class="row">
								<div class="subheader-align col-lg-6">
									(50a)Ordering Customer:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.orderingCustomer}
								</div>
							</div>
							<div class="row">
								<div class="subheader-align col-lg-6">
									(51a)Sending Institution:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.sendingInstitution }
								</div>
							</div>
							<div class="row">
								<div class="subheader-align col-lg-6">
									(57a)Account With Institution:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.accountWithInstitution }
								</div>
							</div>
							<div class="row">
								<div class="subheader-align col-lg-6">
									(59a)Beneficiary Customer:-
								</div>
								<div class="header-data-align col-lg-6">
									${payment.beneficiaryCustomer }
								</div>
							</div>
							<div class="row f-align">
								<form action="http://localhost:8080/approve" method="post">
									<input type="hidden" name="t_id" value=${payment.senderReference }/>
									<input type="submit" class="btn btn-md btn-success" value="approve"/>
								</form>
								<form action="http://localhost:8080/reject" method="post">
									<input type="hidden" name="t_id" value=${payment.senderReference }/>
									<input type="submit" class="btn btn-md btn-danger" value="reject"/>
								</form>
							</div>
							
							
						</div>
					</div>
				</c:forEach>
		</div>
		
		<div class="row" id="paymentTransfer">
			<div class="col d-flex justify-content-center">
				<br> <br>
				<div class="card" style="width: 20rem;">
					<h3 class="card-title">Bank to Bank Payment</h3>
					<div class="card-body">
						<form action="" method="post">
							<div class="form-group">
								<label for="bic">Enter Bank Code</label> <input type="text"
									class="form-control" id="bic" name="bic"
									placeholder="Enter Bank Code">
							</div>
							
							<div class="form-group">
								<label for="bankName">Bank Name</label>
								 <input type="text"
									class="form-control" id="bankName" name="bankName"
									placeholder="Enter bank name">
							</div>
							<div class="form-group">
								<label for="bankAddress">Enter Bank Address</label> 
								<input type="text"
									class="form-control" id="bankAddress" name="bankAddress"
									placeholder="Enter Bank Address">
							</div>
								<div class="form-group">
								<label for="password">Enter Password</label> <input type="text"
									class="form-control" type="password" id="password"
									name="password" placeholder="Enter Password">
							</div>
							
							<div class="form-group">
								<label for="country">Country</label>
								 <input type="text"
									class="form-control" type="country" id="country" name="country"
									placeholder="Enter Country">
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
	
		</div>
	</div>
	
	<script>
		document.getElementById("paymentTransfer").style.display="none";
	
		function showPaymentStatusPage(){
			document.getElementById("paymentTransfer").style.display="none";
			document.getElementById("paymentStatus").style.display="block";
		}
		
		function showBankPaymentPage(){
			document.getElementById("paymentStatus").style.display="none";
			document.getElementById("paymentTransfer").style.display="block";
		}
	</script>
</body>
</html>