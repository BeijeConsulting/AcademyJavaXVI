<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NEW ADDRESS</title>
</head>
<body>

	<form align=center action="./add_address" method="post">
		<label for="label">Etichetta:</label><br>
		<input type="text" name="label"><br>
		<label for="fullName">*Nome completo:</label><br>
		<input type="text" name="fullName" required><br>
		<label for="country">*Paese:</label><br>
		<input type="text" name="country" required><br><br>
		<label for="streetAddress">*Indirizzo:</label><br>
		<input type="text" name="streetAddress" required><br><br>
		<label for="telephone">*Telefono:</label><br>
		<input type="text" name="telephone" required><br>
		<label for="zipcode">*CAP (Zipcode):</label><br>
		<input type="text" name="zipcode" required><br>
		<label for="instructions">Istruzioni:</label><br>
		<input type="text" name="instructions"><br><br>
		<input type="submit" value="Aggiungi">
		<input type="reset" value="Cancella">
	</form> 

</body>
</html>