<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<a class="mr-5" onClick="showCustomerLoginForm()" href="#customer"> Customer login</a>
			<a onClick="showBankLoginForm()" href="#bank"> Bank login</a>
		</div>
		
		<div class="row" id="customer">
			<form class="col-lg-12" action="http://localhost:8080/customerhome" method="post">
				<div class="form-group">
					<label for="email">Email</label>
					<input type="email" name="email" class="form-control" placeholder="Enter Email"/>
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<input type="password" name="password" class="form-control" placeholder="Enter Password"/>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-lg btn-success" value="Log In"/>
				</div>	
			</form>
		</div>
		<div class="row" id="bank">
			<form  class="col-lg-12" action="http://localhost:8080/bankhome" method="post">
				<div class="form-group">
					<label for="bankId">Bank Id</label>
					<input type="text" name="bic" class="form-control" placeholder="Enter Bank Id"/>
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<input type="password" name="password" class="form-control" placeholder="Enter Password"/>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-lg btn-success" value="Log In"/>
				</div>	
			</form>
		</div>
	</div>
	<script>
	
	document.getElementById("bank").style.display="none";
	
	
	function showCustomerLoginForm(){
		document.getElementById("bank").style.display="none";
		document.getElementById("customer").style.display="block";
	}
	
	function showBankLoginForm(){
		document.getElementById("customer").style.display="none";
		document.getElementById("bank").style.display="block";
	}
	</script>
</body>
</html>