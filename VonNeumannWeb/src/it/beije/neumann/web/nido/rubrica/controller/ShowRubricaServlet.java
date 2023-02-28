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
 * Servlet implementation class ShowRubricaServlet
 */
@WebServlet("/nido/controller/show_rubrica")
public class ShowRubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRubricaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Contact> contacts = RubricaJPAWeb.getJPAManager().showRubrica("ASC", "surname");
		HttpSession session = request.getSession();
		
		session.setAttribute("contacts", contacts);

		response.sendRedirect("../view/showcontacts.jsp");
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.sendRedirect("../view/menu.jsp");
//	}

}
