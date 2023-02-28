package it.beije.neumann.web.nido.rubrica.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.neumann.web.nido.rubrica.model.Contact;
import it.beije.neumann.web.nido.rubrica.model.RubricaJPAWeb;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/nido/controller/add_contact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("addEnabled", true);
		response.sendRedirect("../view/addnew.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact newContact = new Contact();
		HttpSession session = request.getSession();
		
		newContact.setName(request.getParameter("name"));
		newContact.setSurname(request.getParameter("surname"));
		newContact.setTelephone(request.getParameter("telephone"));
		newContact.setEmail(request.getParameter("email"));
		newContact.setNote(request.getParameter("note"));
		
		session.setAttribute("contact", newContact);
		RubricaJPAWeb.getJPAManager().addContact(newContact);
		
		response.sendRedirect("../view/reviewcontact.jsp");
		
	}

}
