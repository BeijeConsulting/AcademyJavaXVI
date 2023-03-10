<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Order</title>
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
	<div><h1> &nbsp; My Order</h1></div>
        
        <c:if test="${not empty order}">
        <div class="w3-container">
        <h3>${logged_user.name} ${logged_user.surname}, ecco i tuoi ordini</h3>
        
		<table class="w3-table-all w3-hoverable">
    		<thead>
      			<tr class="w3-deep-orange">
			        <th>Transaction</th>
			        <th>Transaction date</th>
			        <th>Payment status</th>
			        <th>Address name</th>
			        <th>Street address</th>
			        <th>Status</th>
			        <th>Total price</th>
			        <th>Created at</th>
      			</tr>
   			</thead>
    		<c:forEach var="o" items="${order}">
      			<tr>
			        <td>${o.transaction}</td>
			        <td>${o.transactionDate}</td>
			        <td>${o.paymentStatus}</td>
			        <td>${address.label}</td>
			        <td>${address.streetAddress}</td>
			        <td>${o.totalPrice}</td>
			        <td>${o.createdAt}</td>
      			</tr>
    		</c:forEach>
  		</table>
  		
        </div>
    </c:if>

    <c:if test="${empty order}">
        <p class="w3-container">You have not placed any orders yet.</p>
    </c:if>

</body>
</html>