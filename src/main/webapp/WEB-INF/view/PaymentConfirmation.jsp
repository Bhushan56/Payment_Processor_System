<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Status</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
@import url('https://fonts.googleapis.com/css?family=Oswald');

* {
	margin: 0;
	padding: 0;
	border: 0;
	box-sizing: border-box
}

body {
	background-color: #dadde6;
	font-family: arial
}

.fl-left {
	float: left
}

.fl-right {
	float: right
}

.container {
	width: 90%;
	margin: 100px auto
}

h1 {
	text-transform: uppercase;
	font-weight: 900;
	border-left: 10px solid #fec500;
	padding-left: 10px;
	margin-bottom: 30px
}

.row {
	overflow: hidden
}

.card {
	display: table-row;
	width: 49%;
	background-color: #fff;
	color: #989898;
	margin-bottom: 10px;
	font-family: 'Oswald', sans-serif;
	text-transform: uppercase;
	border-radius: 4px;
	position: relative
}

.card+.card {
	margin-left: 2%
}

.date {
	display: table-cell;
	width: 25%;
	position: relative;
	text-align: center;
	border-right: 2px dashed #dadde6
}

.date:before, .date:after {
	content: "";
	display: block;
	width: 30px;
	height: 30px;
	background-color: #DADDE6;
	position: absolute;
	top: -15px;
	right: -15px;
	z-index: 1;
	border-radius: 50%
}

.date:after {
	top: auto;
	bottom: -15px
}

.date time {
	display: block;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%)
}

.date time span {
	display: block
}

.date time span:first-child {
	color: #2b2b2b;
	font-weight: 600;
	font-size: 250%
}

.date time span:last-child {
	text-transform: uppercase;
	font-weight: 600;
	margin-top: -10px
}

.card-cont {
	display: table-cell;
	width: 75%;
	font-size: 85%;
	padding: 10px 10px 30px 50px
}

.card-cont h3 {
	color: #3C3C3C;
	font-size: 130%
}

.row:last-child .card:last-of-type .card-cont h3 {
	
}

.card-cont>div {
	display: table-row
}

.card-cont .even-date i, .card-cont .even-info i, .card-cont .even-date time,
	.card-cont .even-info p {
	display: table-cell
}

.card-cont .even-date i, .card-cont .even-info i {
	padding: 5% 5% 0 0
}

.card-cont .even-info p {
	padding: 30px 50px 0 0
}

.card-cont .even-date time span {
	display: block
}

.card-cont a {
	display: block;
	text-decoration: none;
	width: 80px;
	height: 30px;
	background-color: #D8DDE0;
	color: #fff;
	text-align: center;
	line-height: 30px;
	border-radius: 2px;
	position: absolute;
	right: 10px;
	bottom: 10px
}

.row:last-child .card:first-child .card-cont a {
	background-color: #037FDD
}

.row:last-child .card:last-child .card-cont a {
	background-color: #F8504C
}

@media screen and (max-width: 860px) {
	.card {
		display: block;
		float: none;
		width: 100%;
		margin-bottom: 10px
	}
	.card+.card {
		margin-left: 0
	}
	.card-cont .even-date, .card-cont .even-info {
		font-size: 75%
	}
}
</style>

</head>
<body>
	<div class="container">
		
		<h1>Payment Status</h1>
	
		<div class="row">
			<article class="card fl-left">
				<section class="date">
					<time datetime="23th feb">
						<span>${transaction.amount}</span><span>Rs</span>
					</time>
				</section>
				<section class="card-cont">
					<small></small>
					<h3>${transaction.beneficiaryCustomer.split(",")[0]}</h3>
					<div class="even-date">
						<i class="fa fa-calendar"></i>
						<time>
							<span>${transaction.date }</span>
	
						</time>
					</div>
					<div class="even-info">
						<i class="fa fa-map-marker"></i>
						<p>${transaction.accountWithInstitution} and ${transaction.beneficiaryCustomer.split(",")[1]}</p>
					</div>
					<a href="#">${transaction.status}</a>
				</section>
			</article>
	
		</div>
	</div>
</body>
</html>