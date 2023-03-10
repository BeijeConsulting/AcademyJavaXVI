<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order 2</title>
</head>
<body>
    <h1>Order Details</h1>
    	Order Id : ${order.id}<br>
    	Order Transaction : ${order.transaction}<br>
    	Order Transaction Date : ${order.transactionDate}<br>
    	Order Payment Status : ${order.paymentStatus}<br>
    	Order Status : ${order.status}<br>
    	Order Total Price : ${order.totalPrice}<br>
    	Order User Name : ${order.user.name}<br>
    	Order User Surname : ${order.user.surname}<br>
    	Order Address : ${order.address}<br>
    <form action="/VonNeumannSpring/db3/add_order" method="post">
        <c:forEach items="${order.orderItems}" var="item" varStatus="loop">
    <input type="text" name="orderItems[${loop.index}].id" value="${item.id}" readonly/>
    <input type="text" name="orderItems[${loop.index}].quantity" value="${item.quantity}" readonly/>
    <input type="text" name="orderItems[${loop.index}].size" value="${item.size}" readonly/>
    <input type="text" name="orderItems[${loop.index}].name" value="${item.name}" readonly/>
    <input type="text" name="orderItems[${loop.index}].color" value="${item.color}" readonly/>
    <input type="text" name="orderItems[${loop.index}].productDetails.id" value="${item.productDetails.id}" readonly/>
    <input type="text" name="orderItems[${loop.index}].price" value="${item.price}" readonly/>
</c:forEach>

    	<input type="text" name="transaction" value="${order.transaction}" />
    	<select name="address">
    		<c:forEach items="${addresses}" var="address">
        	<option value="${address.id}">${address.label}</option>
   	 		</c:forEach>
		</select>
        <button type="submit">Add Order</button>
    </form>
</body>
</html>