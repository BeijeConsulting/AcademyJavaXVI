<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
  </head>
  <body class="w3-light-grey">
   
  <!-- Header da mettere ovunque, da aggiungere il controllo per signout invece di signin e register -->
  
    <div class="w3-bar w3-blue w3-padding w3-card">
      <a class="w3-bar-item w3-button w3-hover-white" href="db3">Beije - Shoes First</a>
      <div class="w3-right">
        <a class="w3-bar-item w3-button w3-hover-white" href="db3/signin">Sign-In</a>
        <a class="w3-bar-item w3-button w3-hover-white" href="db3/signout">Sign-Out</a>
      </div>
    </div>
  <!-- Header da mettere ovunque -->
    <div class="w3-container">
      <h1>Product Details</h1>
      <div class="w3-row-padding">
        <c:forEach var="productDetail" items="${productDetails}">
          <div class="w3-col s12 m6 l4">
            <div class="w3-card w3-padding">
              <h3>${productDetail.size}</h3>
              <p>${productDetail.sellingPrice}</p>
              <label for="quantitySel-${productDetail.id}">Quantity:</label>
              <select id="quantitySel-${productDetail.id}">
                <c:forEach var="n" begin="0" end="${productDetail.quantity}">
                  <option value="${n}">${n}</option>
                </c:forEach>
              </select>
              <a href="<c:url value='db3/add_cart/${productDetail.id}'/>" class="w3-button w3-block w3-blue">Add to Shopping-cart</a>
              <br>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </body>
</html> 