package it.beije.neumann.web.elassl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.neumann.web.elassl.contatti.Contatto;
import it.beije.neumann.web.elassl.contatti.ContactManager;
import it.beije.neumann.web.elassl.contatti.DBjpacriteria;

@WebServlet("/getcontacts")
public class progContatti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Set response content type
		response.setContentType("text/html");
		List<Contatto> contacts = new ArrayList<>();
		try {

			ContactManager db = new DBjpacriteria();
			contacts = db.getContatti();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}


	    HttpSession session = request.getSession();
	    session.setAttribute("contacts", contacts);
	    //Forward request and response to jsp file
	    RequestDispatcher rd = request.getRequestDispatcher("/elassl/mvc/list.jsp");
	    rd.forward(request, response);
	    /*
		PrintWriter out = response.getWriter();
	    rd.forward(request, response);
		out.println("<html>");
		out.println("<head><title>Contact Table</title>");

		out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");

		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"w3-container\">");
		out.println("<h2>Lista Contatti</h2>");

		out.println("<table class=\"w3-table-all w3-card-4\">");

		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Surname</th>");
		out.println("<th>Telephone</th>");
		out.println("<th>Email</th>");
		out.println("<th>Note</th>");
		out.println("</tr>");

		for (Contatto c : contacts) {
			out.println("<tr>");
			out.println("<td>" + c.getId() + "</td>");
			out.println("<td>" + c.getName() + "</td>");
			out.println("<td>" + c.getSurname() + "</td>");
			out.println("<td>" + c.getTelephone() + "</td>");
			out.println("<td>" + c.getEmail() + "</td>");
			out.println("<td>" + c.getNote() + "</td>");
			out.println("</tr>");
		}

		out.println("</table></div></body></html>");
		*/

	}

}