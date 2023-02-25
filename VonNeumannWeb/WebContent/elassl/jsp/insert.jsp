<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="it.beije.neumann.web.elassl.contatti.ContactManager,it.beije.neumann.web.elassl.contatti.DBjpacriteria,
                 it.beije.neumann.web.elassl.contatti.Contatto,
                 it.beije.neumann.web.elassl.contatti.DBjpa,
                 java.util.ArrayList,
                 java.util.List" %>
<html>
<head>
    <title>Insert Contact</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container w3-blue">
        <h1>Insert Contact</h1>
    </div>

    <div class="w3-container" class="w3-hoverable w3-card-4">
        <form class="w3-container" action="insert.jsp" method="post">
            <p>Enter the contact details:</p>
            <label>Name:</label><br>
            <input class="w3-input w3-border w3-light-grey" type="text" name="name" required><br>

            <label>Surname:</label><br>
            <input class="w3-input w3-border w3-light-grey" type="text" name="surname" required><br>

            <label>Telephone:</label><br>
            <input class="w3-input w3-border w3-light-grey" type="tel" name="telephone"><br>

            <label>Email:</label><br>
            <input class="w3-input w3-border w3-light-grey" type="email" name="email"><br>

            <label>Notes:</label><br>
            <textarea class="w3-input w3-border w3-light-grey" name="notes"></textarea><br>

            <input class="w3-btn w3-blue" type="submit" value="Insert">
        </form>
    </div>

    <%-- Scriptlet to insert the contact into the database --%>
    <% 
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String notes = request.getParameter("notes");

        if (name != null && surname != null) {
            ContactManager db = new DBjpacriteria();
            Contatto contact = new Contatto(name, surname, telephone, email, notes);
            db.writeContatto(contact);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Contatto inserito con successo!');");
            out.println("</script>");
        }
    %>
</body>
</html>