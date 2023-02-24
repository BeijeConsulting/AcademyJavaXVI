package it.beije.neumann.web.nido.rubrica.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/nido/controller/rubrica")
public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RubricaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<p><strong>Programma di gestione rubrica</strong><p>")
		.append("	<form action=\"../view/menu.jsp\" method=\"post\">\r\n"
				+ "		<input type=\"submit\" value=\"Avvia\">\r\n"
				+ "	</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		int operation = Integer.parseInt(request.getParameter("operation"));

		switch (operation) {

		case 1:
			response.sendRedirect("/neumann/nido/controller/showrubrica");
			break;

		case 2:
			response.sendRedirect("/neumann/nido/controller/searchcontact");
			break;

		case 3:
			response.sendRedirect("/neumann/nido/controller/addcontact");
			break;

		case 4:
			response.sendRedirect("/neumann/nido/controller/editcontact");
			break;

		case 5:
			response.sendRedirect("/neumann/nido/controller/deletecontact");
			break;

		case 6:
			response.sendRedirect("/neumann/nido/controller/searchduplicate");
			break;

		case 7:
			response.sendRedirect("/neumann/nido/controller/mergeduplicate");
			break;

		default:
			session.setAttribute("message", "*Operazione non supportata*");
			response.sendRedirect("../view/menu.jsp");
			break;
		}
	}

}
