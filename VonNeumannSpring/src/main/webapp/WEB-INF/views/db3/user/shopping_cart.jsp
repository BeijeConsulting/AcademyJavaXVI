<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<!-- include the w3.css stylesheet -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

  <h1>Shopping Cart</h1>
  
  <c:if test="${not empty shoppingCart}">
    <!-- display shopping cart items as cards -->
    <c:forEach items="${shoppingCart.shoppingCartItem}" var="item">
      <div class="w3-card-4">
        <div class="w3-container">
          <h3><c:out value="${item.productDetailsId}"/></h3>
          <p>Quantity: <c:out value="${item.quantity}"/></p>
        </div>
      </div>
    </c:forEach>
  </c:if>
  
  <c:if test="${empty shoppingCart}">
    <p>Your shopping cart is empty.</p>
  </c:if>

</body>
</html>