<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page
	import="it.beije.neumann.web.elassl.contatti.ContactManager,
                 it.beije.neumann.web.elassl.contatti.DBjpacriteria,
                 it.beije.neumann.web.elassl.contatti.Contatto,
                 it.beije.neumann.web.elassl.contatti.DBjpa,
                 java.util.ArrayList,
                 java.util.List"%>
<html>
<head>
    <title>Find Duplicates</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container">
        <h1>Find Duplicates</h1>

        <% ContactManager db = new DBjpacriteria();
           List<Contatto> contacts = db.getDuplicates(); %>

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


        <% if (!contacts.isEmpty()) { %>
        <form action="" method="post" onsubmit="return confirm('Are you sure you want to merge these duplicates?');">
            <input type="hidden" name="action" value="merge">
            <input type="submit" value="Merge Duplicates" class="w3-btn w3-green">

        </form> 

       <% } %>

       <% 
          String action = request.getParameter("action");
          if (action != null && action.equals("merge")) {
              db.mergeDuplicates();
              response.sendRedirect("dupes.jsp");
          }
       %>


    </div>


</body>
</html>