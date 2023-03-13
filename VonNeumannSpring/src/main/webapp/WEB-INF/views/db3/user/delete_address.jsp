<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina indirizzo esistente</title>
<!-- Import W3.CSS stylesheet -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
    <h2>Sicuro di voler eliminare il seguente indirizzo?</h2>
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
      </tr>
    </thead>
      <tr>
        <td>${address.label}</td>
        <td>${address.fullName}</td>
        <td>${address.country}</td>
        <td>${address.streetAddress}</td>
        <td>${address.zipcode}</td>
        <td>${address.telephone}</td>
        <td>${address.instructions}</td>
      </tr>
  </table>
  <br>
  
    <div class="w3-container">
	    <form action="../delete_address/${address.id}" method="post">
	      <input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Elimina">
	    </form>
  	</div>
  
    <div class="w3-container">
	    <form action="../addresses" method="post">
	      <input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Annulla">
	    </form>
    <br>
  </div>
  </div>
</body>
</html>