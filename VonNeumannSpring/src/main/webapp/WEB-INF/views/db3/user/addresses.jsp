<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi indirizzi</title>
<!-- Import W3.CSS stylesheet -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

  <div class="w3-container">
  <br>
  <form action="./user_page" method="get">
    <input class="w3-button w3-orange w3-hover-black" type="submit" value="Indietro">
  </form>
  </div>

  <div class="w3-container w3-card-4">
  <h3>${logged_user.name}${logged_user.surname}, ecco i tuoi indirizzi</h3>
  <table class="w3-table-all w3-hoverable">
    <thead>
      <tr class="w3-deep-orange">
        <th>Label</th>
        <th>Full Name</th>
        <th>Country</th>
        <th>Street Address</th>
        <th>Zipcode</th>
        <th>Telephone</th>
        <th>Instructions</th>
        <th>Actions</th>
      </tr>
    </thead>
    <c:forEach var="address" items="${logged_user.addresses}">
      <tr>
        <td>${address.label}</td>
        <td>${address.fullName}</td>
        <td>${address.country}</td>
        <td>${address.streetAddress}</td>
        <td>${address.zipcode}</td>
        <td>${address.telephone}</td>
        <td>${address.instructions}</td>
        <td>[edit/delete]</td>
      </tr>
    </c:forEach>
  </table>

  <div class="w3-container">
    <form action="./add_address" method="get">
      <input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Aggiungi indirizzo">
    </form>
    <br>
  </div>
  </div>

</body>
</html>