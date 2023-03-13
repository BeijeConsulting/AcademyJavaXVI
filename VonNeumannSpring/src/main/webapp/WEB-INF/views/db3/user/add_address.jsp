<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Address</title>
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
		<div class="w3-container w3-card-4">
				<h3>Add Address</h3>

			<form class="w3-container" action="./add_address" method="post">
				<label class="w3-text-black" for="label"><b>Label:</b></label><br>
				<input class="w3-input w3-border" type="text" name="label"><br>
				<label class="w3-text-black" for="fullName"><b>*Full Name:</b></label><br>
				<input class="w3-input w3-border" type="text" name="fullName" required><br>
				<label class="w3-text-black" for="country"><b>*Country:</b></label><br>
				<input class="w3-input w3-border" type="text" name="country" required><br>
				<label class="w3-text-black" for="streetAddress"><b>*Address:</b></label><br>
				<input class="w3-input w3-border" type="text" name="streetAddress"required><br>
				<label class="w3-text-black" for="telephone"><b>*Telephone:</b></label><br>
				<input class="w3-input w3-border" type="text" name="telephone"required><br>
				<label class="w3-text-black" for="zipcode"><b>*Zipcode (CAP):</b></label><br>
				<input class="w3-input w3-border" type="text" name="zipcode" required><br>
				<label class="w3-text-black" for="instructions"><b>Instructions:</b></label><br>
				<input class="w3-input w3-border" type="text" name="instructions"><br><br>
				<input class="w3-button w3-deep-orange w3-hover-black" type="submit" value="Add">
				<input class="w3-button w3-deep-orange w3-hover-black" type="reset" value="Delete">
			</form>
			<br>
			<br>
		</div>
	</div>

</body>
</html>