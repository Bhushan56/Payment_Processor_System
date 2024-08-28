<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script>
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
	</script>
</head>
<body>
    <div class="container">
		<div class="row">
			<a class="mr-2" onClick="showPaymentPage()" href="#pay">View Customer Payment</a>
			<a class="mr-2" onClick="showApprovedPaymentPage()" href="#approvedPayments">Approved Transactions</a>
			<a class="mr-2" onClick="showRejectedPaymentPage()" href="#RejectedPayments">Rejected Transactions</a>
		</div>
	<div id="paymentPage">
	<div class="col d-flex justify-content-center" id="paymentPage">
		<br>
		<br>
		<div class="card" style="width: 20rem;">
			<h3 class="card-title">Pay here</h3>
			<div class="card-body">
				<form action="http://localhost:8080/pay" method="post">
					<div class="form-group">
						<label for="senderAccountBalance">Available balance</label> 
						<input type="text" class="form-control" id="senderAccountBalance" name="senderAccountBalance" value="${user.amount}" readonly>
					</div>
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
						<input type="number" class="form-control" id="userId" name="beneficiaryUserId" placeholder="Enter user ID" required>
					</div>
					<div class="form-group">
						<label for="beneficiaryName">Receiver's Name</label> <input type="text"
							class="form-control" id="beneficiaryName" name="beneficiaryName"
							placeholder="Enter name" required>
					</div>
					
					<div class="form-group">
						<label for="mobileNumber">Receiver Mobile Number</label> <input type="number"
							class="form-control" id="receiverMobileNumber" name="receiverMobileNumber"
							placeholder="Enter mobile number" required>
					</div>
					<div class="form-group">
						<label for="bic">Receiver Bank Code</label> <input type="text"
							class="form-control" id="bic" name="bic"
							placeholder="Enter Bank Code" required>
					</div>
					<div class="form-group">
						<label for="beneficiaryAccountNumber">Receiver Account number</label> 
						<input type="text" class="form-control" id="beneficiaryAccountNumber"
							name="beneficiaryAccountNumber" placeholder="Enter Account Number" required>
					</div>
					<div class="form-group">
						<label for="amount">Enter Amount</label> <input type="text"
							class="form-control" id="amount" name="amount"
							placeholder="Enter Amount" required>
					</div>
					<button type="submit" onsubmit="func()"class="btn btn-primary">Pay</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	
		<div class="row" id="approvedPayments">
				<c:forEach var="payment" items="${approvedTransaction}">
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
							 
							
						</div>
					</div>
				</c:forEach>
		</div>
		<div class="row" id="rejectedPayments">
				<c:forEach var="payment" items="${rejectedTransaction}">
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
							 
							
						</div>
					</div>
				</c:forEach>
		</div>
		</div>
		<script>
		 
		document.getElementById("approvedPayments").style.display="none";
		document.getElementById("rejectedPayments").style.display="none";
	
		function showPaymentPage(){
		    document.getElementById("paymentPage").style.display="block";
 			document.getElementById("approvedPayments").style.display="none";
			document.getElementById("rejectedPayments").style.display="none";
		}
		
		function showApprovedPaymentPage(){
		    document.getElementById("approvedPayments").style.display="block";
		     document.getElementById("paymentPage").style.display="none";
 			document.getElementById("rejectedPayments").style.display="none";
		}
		function showRejectedPaymentPage(){
		    document.getElementById("rejectedPayments").style.display="block";
		    document.getElementById("paymentPage").style.display="none";
			document.getElementById("approvedPayments").style.display="none";
			
		}
	</script>
</body>
</html>