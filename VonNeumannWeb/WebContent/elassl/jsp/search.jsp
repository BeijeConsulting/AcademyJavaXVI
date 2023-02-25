<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page
	import="it.beije.neumann.web.elassl.contatti.ContactManager,it.beije.neumann.web.elassl.contatti.DBjpacriteria,
                 it.beije.neumann.web.elassl.contatti.Contatto,
                 it.beije.neumann.web.elassl.contatti.DBjpa,
                 java.util.ArrayList,
                 java.util.List"%>
<html>
<head>
    <title>Search Contact</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container">
        <h1>Search Contact</h1>

        <form action="search.jsp" method="get" class="w3-container">
            <label for="name">Name:</label> 
            <input type="text" id="name" name="name" class="w3-input w3-border w3-light-grey"><br> 
            <label for="surname">Surname:</label> 
            <input type="text" id="surname" name="surname" class="w3-input w3-border w3-light-grey"><br> 
            <input type="submit" value="Search" class="w3-btn w3-blue">
        </form>

        <% String name = request.getParameter("name");
           String surname = request.getParameter("surname");
           ContactManager db = new DBjpacriteria();
           if (name != null || surname != null) {
               Contatto contact = new Contatto(name, surname, null, null, null);
               List<Contatto> contacts = db.getContatto(contact); %>

        <table class="w3-table-all w3-hoverable w3-card-4">
            <tr class= "w3-blue">
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Telephone</th>
                <th>Email</th>
                <th>Note</th>
            </tr>

            <% for (Contatto c : contacts) { %>

            <tr>
                <td><%=c.getId()%></td>
                <td><%=c.getName()%></td>
                <td><%=c.getSurname()%></td>
                <td><%=c.getTelephone()%></td>
                <td><%=c.getEmail()%></td>
                <td><%=c.getNote()%></td>
            </tr>

            <% } %>

        </table>

    </div>

    <% } %>

</body>
</html>