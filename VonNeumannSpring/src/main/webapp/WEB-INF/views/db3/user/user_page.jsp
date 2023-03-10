<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<!-- Header da mettere ovunque -->


	<div class="w3-bar w3-deep-orange w3-padding w3-card">
		<a class="w3-bar-item w3-button w3-hover-white"
			href="/VonNeumannSpring/db3">Beije - Shoes First</a>
		<div class="w3-right">
			<a href="/VonNeumannSpring/db3/shopping_cart"
				class="w3-button w3-deep-orange w3-hover-black"> 
				<i class="fa fa-shopping-cart"></i> Shopping Cart
			</a>
			<c:choose>
				<c:when test="${empty logged_user}">
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/signin">Sign-In</a>
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/signup">Sign-Up</a>
				</c:when>
				<c:otherwise>
					<a class="w3-bar-item w3-button w3-hover-white"
						href="/VonNeumannSpring/db3/signout">Sign-Out</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- Header da mettere ovunque -->
  <div class="w3-container">
    <h2>Ciao ${logged_user.name}!</h2>
  </div>
  <br>
  <div class="w3-container">
    <table class="w3-table-all">
      <thead>
        <tr class="w3-deep-orange">
          <th>Name</th>
          <th>Surname</th>
          <th>Telephone</th>
          <th>E-mail</th>
          <th>Birth Date</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${logged_user.tableFormat}</td>
        </tr>
      </tbody>
    </table>
  </div>
  <br>
  <div class="w3-container">
    <h4>Cosa vuoi fare?</h4>
    <br>
    <form action="./edit_user" method="get">
      <button class="w3-button w3-orange w3-hover-black">Modifica dettagli</button>
    </form>
    <br>
    <form action="./my_order" method="get">
      <button class="w3-button w3-orange w3-hover-black">Visualizza i miei ordini</button>
    </form>
    <br>
    <form action="./addresses" method="get">
      <button class="w3-button w3-orange w3-hover-black">Visualizza i miei indirizzi</button>
    </form>
  </div>
</body>
</html>