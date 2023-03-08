<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


	<!-- Header da mettere ovunque -->


	<div class="w3-bar w3-deep-orange w3-padding w3-card">
		<a class="w3-bar-item w3-button w3-hover-white"
			href="/VonNeumannSpring/db3">Beije - Shoes First</a>
		<div class="w3-right">
			<a href="/VonNeumannSpring/db3/shopping_cart"
				class="w3-button w3-deep-orange w3-hover-black"> 
				<i class="fa fa-shopping-cart"></i> Shopping Cart
			</a>
			<c:choose>
				<c:when test="${empty logged_user}">
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/signin">Sign-In</a>
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/signup">Sign-Up</a>
				</c:when>
				<c:otherwise>
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/user_page">User page</a>
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/signout">Sign-Out</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- Header da mettere ovunque -->
	<div class="w3-container">
		<h1 class="w3-margin-top">Product List</h1>
		<div class="w3-row-padding">
			<c:forEach var="product" items="${products}">
				<div class="w3-third w3-margin-bottom">
					<div class="w3-card">
						<div class="w3-container">
							<h5>${product.name}</h2>
								<p>${product.description}</p>
								<a href="<c:url value="db3/product/${product.id}"/>"
									class="w3-button w3-block w3-deep-orange">View Details</a> <br>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- JavaScript -->
	<script src="https://www.w3schools.com/lib/w3.js"></script>

</body>
</html>