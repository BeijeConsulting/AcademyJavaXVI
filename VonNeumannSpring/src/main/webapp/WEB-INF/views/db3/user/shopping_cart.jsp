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
	<div><h1> &nbsp; Shopping Cart</h1></div>
        
    <c:if test="${not empty shoppingCart}">
        <div class="w3-container">
            <c:forEach items="${shoppingCart.shoppingCartItem}" var="item">
            	<c:if test="${empty item.disabledAt}">
                <div class="w3-card-4 w3-margin">
                    <div class="w3-container">
                        <h3> Id: <c:out value="${item.productDetailsId}"/></h3>
                        <p>Quantity: <c:out value="${item.quantity}"/></p>
                        <a class="w3-bar-item w3-button w3-red w3-hover-black w3-margin"
			href="/VonNeumannSpring/db3/remove_cart_item/${item.id}">Remove Item</a>
                    </div>
                </div>
                 </c:if>
            </c:forEach>
            <c:if test="${not empty shoppingCart.shoppingCartItem}">
		        <a class="w3-bar-item w3-button w3-orange w3-hover-black w3-margin"
			href="/VonNeumannSpring/db3/order">Buy</a>
		    </c:if>
        </div>
    </c:if>

    <c:if test="${empty shoppingCart}">
        <p class="w3-container">Your shopping cart is empty.</p>
    </c:if>

</body>
</html>