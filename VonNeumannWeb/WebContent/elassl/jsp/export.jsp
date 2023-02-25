<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String option = request.getParameter("option");
	if(option!=null)
	    switch (option) {
	        case "list":
	            response.sendRedirect("jsp/list.jsp");
	            break;
	        case "delete":
	            response.sendRedirect("jsp/delete.jsp");
	            break;
	        case "handle":
	            response.sendRedirect("jsp/dupes.jsp");
	            break;
	        case "insert":
	            response.sendRedirect("jsp/insert.jsp");
	            break;
	        case "import":
	            response.sendRedirect("jsp/import.jsp");
	            break;
	        case "export":
	            response.sendRedirect("jsp/export.jsp");
	            break;
	        default:
	            out.println("Invalid option.");
	    }
%>
<html>
<head>
    <title>Address Book Manager</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
    <div class="w3-container w3-teal">
        <h1>Address Book Manager</h1>
    </div>

    <div class="w3-container">
        <form action="sandbox.jsp" method="post">
            <p>Select an option:</p>
            <input class="w3-radio" type="radio" name="option" value="list" checked>
            <label>List all contacts</label><br>

            <input class="w3-radio" type="radio" name="option" value="delete">
            <label>Delete a contact</label><br>

            <input class="w3-radio" type="radio" name="option" value="handle">
            <label>Handle duplicate contacts</label><br>

            <input class="w3-radio" type="radio" name="option" value="insert">
            <label>Insert a new contact</label><br>

            <input class="w3-radio" type="radio" name="option" value="import">
            <label>Import contacts from a file</label><br>

            <input class="w3-radio" type="radio" name="option" value="export">
            <label>Export contacts to a file</label><br>

            <input class="w3-button w3-teal w3-margin-top" type="submit" value="Submit">
        </form>
    </div>
</body>
</html>