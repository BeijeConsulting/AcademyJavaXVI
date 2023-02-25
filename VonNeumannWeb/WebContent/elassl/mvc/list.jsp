<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="it.beije.neumann.web.elassl.contatti.ContactManager,it.beije.neumann.web.elassl.contatti.DBjpacriteria,
                 it.beije.neumann.web.elassl.contatti.Contatto,
                 java.util.ArrayList,
                 java.util.List" %>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<div class="w3-container">
    <h1>Contact List</h1>
    <% List<Contatto> contacts = (List<Contatto>) session.getAttribute("contacts");
     %>
    <table class="w3-table-all w3-hoverable w3-card-4">
        <tr class="w3-blue">
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>Note</th>
        </tr>

        <% for (Contatto contatto : contacts) { %>

            <tr>
                <td><%= contatto.getId() %></td>
                <td><%= contatto.getName() %></td>
                <td><%= contatto.getSurname() %></td>
                <td><%= contatto.getTelephone() %></td>
                <td><%= contatto.getEmail() %></td>
                <td><%= contatto.getNote() %></td>

            </tr>

        <% } %> 

    </table>
	</div>
</body>

</html>
