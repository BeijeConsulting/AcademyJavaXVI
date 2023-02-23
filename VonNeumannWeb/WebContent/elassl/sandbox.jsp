<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="it.beije.neumann.elassl.contatti.ContactManager,
                 it.beije.neumann.elassl.contatti.DBjpacriteria,
                 it.beije.neumann.rubrica.Contatto,
                 java.util.ArrayList,
                 java.util.List" %>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script>
        // This function filters the table rows based on user inputs
        function filterTable() {
            // Declare variables
            var inputId, inputName, inputSurname, filterId, filterName, filterSurname;
            var table, tr, tdId, tdName, tdSurname;
            inputId = document.getElementById("searchInputId");
            inputName = document.getElementById("searchInputName");
            inputSurname = document.getElementById("searchInputSurname");
            filterId = inputId.value.toUpperCase();
            filterName = inputName.value.toUpperCase();
            filterSurname = inputSurname.value.toUpperCase();
            table = document.getElementById("contactTable");
            tr = table.getElementsByTagName("tr");

            // Loop through all table rows and hide those who don't match
            for (var i = 0; i < tr.length; i++) {
                tdId = tr[i].getElementsByTagName("td")[0];
                tdName = tr[i].getElementsByTagName("td")[1];
                tdSurname = tr[i].getElementsByTagName("td")[2];
                if (tdId && tdName && tdSurname) {
                    var txtId = tdId.textContent || tdId.innerText;
                    var txtName = tdName.textContent || tdName.innerText;
                    var txtSurname = tdSurname.textContent || tdSurname.innerText;
                    // Check if user inputs match id or name or surname
                    if (txtId.toUpperCase().indexOf(filterId) > -1 ||
                        txtName.toUpperCase().indexOf(filterName) > -1 ||
                        txtSurname.toUpperCase().indexOf(filterSurname) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</head>
<body>

	<div class="w3-container">
    <h1>Contact List</h1>

    <!-- These are the input elements for user to enter search criteria -->
    <input type="text" id="searchInputId" onkeyup="filterTable()" placeholder="Search by id">
    <input type="text" id="searchInputName" onkeyup="filterTable()" placeholder="Search by name">
    <input type="text" id="searchInputSurname" onkeyup="filterTable()" placeholder="Search by surname">

    <% List<Contatto> contacts = new ArrayList<>();
		try {

			ContactManager db = new DBjpacriteria();
			contacts = db.getContatti();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
     %>

     <!-- This is the table element with an id -->
    <table class="w3-table-all w3-hoverable w3-card-4" id="contactTable">
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
