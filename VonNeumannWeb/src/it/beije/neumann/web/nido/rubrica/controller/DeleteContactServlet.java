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
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/nido/controller/delete_contact")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("deleteEnabled", true);
		response.sendRedirect("../view/searchby.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Contact deleted = (Contact) session.getAttribute("contact");

		String idcontact = request.getParameter("idcontact");

		if (idcontact != null) {
			int id = Integer.parseInt(idcontact);

			for (Contact c : (List<Contact>) session.getAttribute("contacts")) {
				if (c.getId() == id) {
					session.setAttribute("contact", c);
				}
			}
			session.removeAttribute("idcontact");
			response.sendRedirect("../controller/deletecontact");
		} else {

			RubricaJPAWeb.getJPAManager().deleteContact(deleted);
			session.setAttribute("contact", deleted);

			response.sendRedirect("../view/reviewcontact.jsp");
		}
	}

}
