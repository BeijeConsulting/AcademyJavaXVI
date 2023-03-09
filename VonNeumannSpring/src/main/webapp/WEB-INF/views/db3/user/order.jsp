<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order</title>
</head>
<body>
    <h1>Order Details</h1>
    <c:set var="order" value="${order}" />
    <form action="/VonNeumannSpring/db3/add_order" method="post">
        <input type="text" name="id" value="${order.id}" />
        <input type="text" name="transaction" value="${order.transaction}" />
        <input type="text" name="transactionDate" value="${order.transactionDate}" />
        <input type="text" name="paymentStatus" value="${order.paymentStatus}" />
        <input type="text" name="status" value="${order.status}" />
        <input type="text" name="totalPrice" value="${order.totalPrice}" />
        <input type="text" name="user" value="${order.user}" />
        <input type="text" name="address" value="${order.address}" />
        <c:forEach items="${orderItems}" var="item">
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
<!-- 
<!DOCTYPE html>
<html>
<head>
 <title>Insert Order Form</title>
</head>
<body>

 <h2>Insert Order</h2>

 <form action="insert_order" method="post">

  <label for="transaction">Transaction:</label>
  <input type="text" id="transaction" name="transaction"><br><br>

  <label for="transaction_date">Transaction Date:</label>
  <input type="datetime-local" id="transaction_date" name="transaction_date"><br><br>

  <label for="payment_status">Payment Status:</label>
  <input type="text" id="payment_status" name="payment_status"><br><br>

  <label for="status">Status:</label>
  <input type="text" id="status" name="status"><br><br>

  <label for="total_price">Total Price:</label>
  <input type="number" id="total_price" name="total_price"><br><br>

  <label for="user_id">User ID:</label>
  <input type="number" id="user_id" name="user_id"><br><br>

  <input type="submit" value="Insert Order">

 </form>

</body>
</html> 

 -->