<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order detail</title>
<!-- include the w3.css stylesheet -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
	<!-- Header da mettere ovunque -->

	<div class="w3-bar w3-deep-orange w3-padding w3-card">
		<a class="w3-bar-item w3-button w3-hover-white"
			href="/VonNeumannSpring/db3">Beije - Shoes First</a>
		<div class="w3-right">
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
	<div><h1> &nbsp; Order detail</h1></div>
	
	    <div class="w3-container">
        <h3>${logged_user.name} ${logged_user.surname}, ecco i dettagli dell'ordine</h3>

		<table class="w3-table-all w3-hoverable">
    		<thead>
      			<tr class="w3-deep-orange">
			        <th>Quantity</th>
			        <th>Price</th>
			        <th>Size</th>
			        <th>Name</th>
			        <th>Color</th>
      			</tr>
   			</thead>
    		<c:forEach var="it" items="${items}">
      			<tr>
			        <td>${it.quantity}</td>
			        <td>${it.price}</td>
			        <td>${it.size}</td>
			        <td>${it.name}</td>
			        <td>${it.color}</td>
      			</tr>
    		</c:forEach>
  		</table>

        </div>
	
</body>
</html>