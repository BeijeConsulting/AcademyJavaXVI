<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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
		<div class="w3-right"></div>
	</div>
	<!-- Header da mettere ovunque -->


	<div class="w3-container">
		<br>
		<div class="w3-container w3-card-4">
				<h3>Sign-Up</h3>

			<form class="w3-container" action="./signup" method="post">
				<label class="w3-text-black" for="name"><b>*Nome:</b></label><br>
				<input class="w3-input w3-border" type="text" name="name" required
					value="${signup_user.name}"><br> <label
					class="w3-text-black" for="surname"><b>*Cognome:</b></label><br>
				<input class="w3-input w3-border" type="text" name="surname"
					required value="${signup_user.surname}"><br> <label
					class="w3-text-black" for="email"><b>*Email:</b></label><br> <input
					class="w3-input w3-border" type="email" name="email" required
					value="${signup_user.email}"><br> <label
					class="w3-text-black" for="password"><b>*Password:</b></label><br>
				<input class="w3-input w3-border" type="password" name="password"
					required><br> <label class="w3-text-black"
					for="birthdate"><b>*Data di nascita:</b></label><br> <input
					class="w3-input w3-border" type="date" name="birthdate" required
					value="${signup_user.birthDate}"><br> <label
					class="w3-text-black" for="telephone"><b>Telefono:</b></label><br>
				<input class="w3-input w3-border" type="text" name="telephone"
					value="${signup_user.telephone}"><br>
				<br> <input class="w3-button w3-deep-orange w3-hover-black"
					type="submit" value="Sign-Up"> <input
					class="w3-button w3-deep-orange w3-hover-black" type="reset"
					value="ANNULLA">
			</form>
			<br>
			<c:choose>
				<c:when test="${not empty signup_error}">
					<h4 align=center style="color: red;">
						<b>${signup_error}</b>
					</h4>
				</c:when>
			</c:choose>
		</div>
	</div>

</body>
</html>