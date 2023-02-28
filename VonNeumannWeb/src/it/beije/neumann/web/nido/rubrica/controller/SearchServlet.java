package it.beije.neumann.web.nido.rubrica.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.neumann.web.nido.rubrica.model.Contact;
import it.beije.neumann.web.nido.rubrica.model.RubricaJPAWeb;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/nido/controller/search_contact")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../view/searchby.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		HttpSession session = request.getSession();

		
		List<Contact> results = RubricaJPAWeb.getJPAManager().searchContact(name, surname);
		session.setAttribute("contacts", results);
		
		response.sendRedirect("../view/showcontacts.jsp");
		
		
	}

}
