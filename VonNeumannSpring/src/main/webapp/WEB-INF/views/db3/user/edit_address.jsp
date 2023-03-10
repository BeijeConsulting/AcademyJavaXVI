<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica dettagli indirizzo</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
  <!-- Header da mettere ovunque -->
  <div class="w3-bar w3-deep-orange w3-padding w3-card">
    <a class="w3-bar-item w3-button w3-hover-white" href="/VonNeumannSpring/db3">Beije - Shoes First</a>
    <div class="w3-right">
      <a class="w3-bar-item w3-button w3-hover-white" href="/VonNeumannSpring/db3/user_page">User page</a>
    </div>
  </div>
  <!-- Header da mettere ovunque -->
  
  <div class="w3-container">
    <br>
    <h2> Edit Address: </h2>
    <form class="w3-container" action="../edit_address/${address.id}" method="post">
      <label for="label">Label:</label><br>
      <input class="w3-input w3-border" type="text" name="label" value="${address.label}"><br>
      <label for="fullName">*FullName</label><br>
      <input class="w3-input w3-border" type="text" name="fullName" value="${address.fullName}" required><br>
      <label for="country">*Country:</label><br>
      <input class="w3-input w3-border" type="text" name="country" value="${address.country}" required><br>
      <label for="streetAddress">*Address:</label><br>
      <input class="w3-input w3-border" type="text" name="streetAddress" value="${address.streetAddress}" required><br>
      <label for="telephone">*Telephone:</label><br>
      <input class="w3-input w3-border" type="tel" name="telephone" value="${address.telephone}"><br>
      <label for="zipcode">*Zipcode:</label><br>
      <input class="w3-input w3-border" type="text" name="zipcode" value="${address.zipcode}" required><br>
      <label for="instructions">Instructions:</label><br>
      <input class="w3-input w3-border" type="text" name="instructions" value="${address.instructions}"><br><br>
      <input type="hidden" name="userId" value="${address.userId}">
      <input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Save">
    </form>
    <br>
  </div>
</body>
</html>