<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<!-- Header da mettere ovunque -->
	<div class="w3-bar w3-deep-orange w3-padding w3-card">
		<a class="w3-bar-item w3-button w3-hover-white"
			href="/VonNeumannSpring/db3">Beije - Shoes First</a>
		<div class="w3-right">
			<a class="w3-bar-item w3-button w3-hover-white"
				href="/VonNeumannSpring/db3/user_page">User page</a>
		</div>
	</div>
	<!-- Header da mettere ovunque -->
	<div class="w3-container">
    <h3>Order Details:</h3>
    <form action="/VonNeumannSpring/db3/add_order" method="post">
    <table class="w3-table-all w3-hoverable">
			<thead>
				<tr class="w3-deep-orange">
					<th>Order Code</th>
					<th>Transaction</th>
					<th>Transaction Date</th>
					<th>Payment Status</th>
					<th>Order Status</th>
					<th>Total Price</th>
				</tr>
			</thead>
			
			<tr>
				<td>${order.id}</td>
				<td><input type="text" name="transaction" value="${order.transaction}" /></td>
				<td>${order.transactionDate}</td>
				<td>${order.paymentStatus}</td>
				<td>${order.status}</td>
				<td>${order.totalPrice}</td>
			</tr>
    </table>
    <br>
    
					<h3>Ordered Product details:</h3>
    
    <table class="w3-table-all w3-hoverable">
			<thead>
				<tr class="w3-deep-orange">
					<th>Item code</th>
					<th>Name</th>
					<th>Color</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Price</th>
				</tr>
			</thead>
			
			<c:forEach items="${order.orderItems}" var="item" varStatus="loop">
			<tr>
				<td><input type="text" name="orderItems[${loop.index}].id" value="${item.id}" readonly/></td>
				<td><input type="text" name="orderItems[${loop.index}].name" value="${item.name}" readonly/></td>
				<td><input type="text" name="orderItems[${loop.index}].color" value="${item.color}" readonly/></td>
				<td><input type="text" name="orderItems[${loop.index}].quantity" value="${item.quantity}" readonly/></td>
				<td><input type="text" name="orderItems[${loop.index}].size" value="${item.size}" readonly/></td>
				<td><input type="text" name="orderItems[${loop.index}].price" value="${item.price}" readonly/></td>
			</tr>
			</c:forEach>
    </table>

	<p>Send to:</p>
    	<select name="address" class="w3-input">
    		<c:forEach items="${addresses}" var="address">
    		<c:choose>
    		<c:when test="${empty address.disabledAt}">
        		<option value="${address.id}">${address.label}</option>
        	</c:when>
        	</c:choose>
   	 		</c:forEach>
		</select>
		<br>
        <button class="w3-button w3-orange" type="submit">Confirm Order</button>
    </form>
    </div>
</body>
</html>