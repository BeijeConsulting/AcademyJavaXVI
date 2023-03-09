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
        <c:forEach items="${order.orderItems}" var="item">
            <input type="text" name="id" value="${item.id}" />
            <input type="text" name="quantity" value="${item.quantity}" />
            <input type="text" name="price" value="${item.price}" />
            <input type="text" name="size" value="${item.size}" />
            <input type="text" name="name" value="${item.name}" />
            <input type="text" name="color" value="${item.color}" />
            <input type="text" name="createdAt" value="${item.createdAt}" />
            <input type="text" name="disabledAt" value="${item.disabledAt}" />
            <input type="text" name="productDetails" value="${item.productDetails.id}" />
        </c:forEach>
        <button type="submit">Add Order</button>
    </form>
</body>
</html>