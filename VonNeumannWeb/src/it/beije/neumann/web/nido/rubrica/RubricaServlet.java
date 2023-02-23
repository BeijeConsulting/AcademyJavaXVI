package it.beije.neumann.web.nido.rubrica;

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
@WebServlet("/nido/rubrica")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		HttpSession session = request.getSession();

		int operation = Integer.parseInt(request.getParameter("operation"));

		switch (operation) {

		case 1:
			response.sendRedirect("./operation1.jsp");
			break;

		case 2:
			response.sendRedirect("./operation2.jsp");
			break;

		case 3:
			response.sendRedirect("./operation3.jsp");
			break;

		case 4:
			response.sendRedirect("./operation4.jsp");
			break;

		case 5:
			session.setAttribute("message", "*Stiamo lavorando per voi :D*");
			response.sendRedirect("./menu.jsp");
			break;

		case 6:
			session.setAttribute("message", "*Stiamo lavorando per voi :D*");
			response.sendRedirect("./menu.jsp");
			break;

		case 7:
			session.setAttribute("message", "*Stiamo lavorando per voi :D*");
			response.sendRedirect("./menu.jsp");
			break;

		default:
			session.setAttribute("message", "*Operazione non supportata*");
			response.sendRedirect("./menu.jsp");
			break;
		}
	}

}
