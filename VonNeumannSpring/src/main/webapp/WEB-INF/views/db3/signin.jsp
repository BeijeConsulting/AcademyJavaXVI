<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> LOGIN </title>
<!-- Import W3.CSS stylesheet -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body >
  <!-- Header da mettere ovunque -->
  	
    
    <div class="w3-bar w3-deep-orange w3-padding w3-card">
      <a class="w3-bar-item w3-button w3-hover-white" href="/VonNeumannSpring/db3">Beije - Shoes First</a>
      <div class="w3-right">
      </div>
    </div>
  <!-- Header da mettere ovunque -->
  
<div class="w3-container">
<br>
  <div class="w3-container w3-card-4">
    <h2>Sign In</h2>
    <form class="w3-container" action="./signin" method="post">
      <label  for="email">Email:</label><br>
      <input class="w3-input" type="email" name="email"><br><br>
      <label for="password">Password:</label><br>
      <input class="w3-input" type="password" name="password"><br><br>
      <input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Sign In">
      <input class="w3-button w3-deep-orange w3-hover-black" type="reset" value="Cancel">
    </form> 
    
      <br>
    <!-- Show error message if there is one -->
    <c:choose>
      <c:when test="${not empty signin_error}">
        <br><span style="color: red; font-weight: bold">${signin_error}</span>
        <br>
      </c:when>
    </c:choose>
  </div>
  </div>
</body>
</html>