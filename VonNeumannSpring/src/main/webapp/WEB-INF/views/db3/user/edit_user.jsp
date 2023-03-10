<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica dettagli utente</title>
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
    <h2>Edit User info</h2>
    <form class="w3-container" action="./edit_user" method="post">
      <label for="name">*Name</label><br>
      <input class="w3-input w3-border" type="text" name="name" value="${logged_user.name}" required><br>
      <label for="surname">*Surname</label><br>
      <input class="w3-input w3-border" type="text" name="surname" value="${logged_user.surname}" required><br>
      <label for="email">*Email</label><br>
      <input class="w3-input w3-border" type="email" name="email" value="${logged_user.email}" required><br>
      <label for="password">*Password</label><br>
      <input class="w3-input w3-border" type="password" name="password" value="${logged_user.password}" required><br>
      <label for="telephone">Telephone</label><br>
      <input class="w3-input w3-border" type="tel" name="telephone" value="${logged_user.telephone}"><br>
      <label for="birthdate">*Birth Date</label><br>
      <input class="w3-input w3-border" type="date" name="birthdate" value="${logged_user.birthDate}" required><br><br>
      <input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Save">
    </form>
    <br>
  </div>
</body>
</html>