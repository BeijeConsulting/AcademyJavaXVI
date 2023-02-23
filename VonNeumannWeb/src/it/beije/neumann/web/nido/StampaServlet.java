package it.beije.neumann.web.nido;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProvaServlet
 */
@WebServlet("/nido/prova")
public class StampaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StampaServlet() {
		super();
		System.out.println("Servlet generata :D");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Nido Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		String openTag = "<html><body><p>";
		String closeTag = "</p></body></html>";

		System.out.println("name = " + name);
		System.out.println("surname = " + surname);

		response.getWriter().append(openTag).append("FIRST NAME: ").append(name).append("<br/>").append("LAST NAME: ")
				.append(surname).append(closeTag);
	}

	
}
