<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi indirizzi</title>
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
			<a class="w3-bar-item w3-button w3-hover-white"
				href="/VonNeumannSpring/db3/user_page">User page</a>
		</div>
	</div>
	<!-- Header da mettere ovunque -->

	<div class="w3-container w3-card-4">
		<h3>${logged_user.name}&nbsp;${logged_user.surname}, Your Addresses are:</h3>
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
					<th></th>
					<th></th>
				</tr>
			</thead>
			<c:forEach var="address" items="${logged_user.addresses}">
				<c:choose>
					<c:when test="${empty address.disabledAt}">
						<tr>
							<td>${address.label}</td>
							<td>${address.fullName}</td>
							<td>${address.country}</td>
							<td>${address.streetAddress}</td>
							<td>${address.zipcode}</td>
							<td>${address.telephone}</td>
							<td>${address.instructions}</td>
							<td><a
								href="<c:url value='/db3/edit_address/${address.id}'/>"
								class="w3-button w3-block w3-deep-orange">Edit</a></td>
							<td><a
								href="<c:url value='/db3/delete_address/${address.id}'/>"
								class="w3-button w3-block w3-deep-orange">Delete</a></td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</table>

		<br>
		<div class="w3-container">
			<form action="./add_address" method="get">
				<input class="w3-button w3-deep-orange w3-hover-black" type="submit"
					value="Add Address">
			</form>
			<br>
		</div>
	</div>

</body>
</html>