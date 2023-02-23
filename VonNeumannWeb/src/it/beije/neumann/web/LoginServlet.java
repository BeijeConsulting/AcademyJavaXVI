package it.beije.neumann.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("session in LoginServlet: " + session.getId());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		
		if (username != null && username.equalsIgnoreCase("pippo@beije.it") && password != null && password.equals("12345")) {
//			response.getWriter().append("<html><body><p>CIAO ").append(username).append("</p></body></html>");
			session.setAttribute("username", username);
			response.sendRedirect("./welcome.jsp");
		} else {
//			response.sendRedirect("./login.jsp?message=CREDENZIALI_ERRATE");
			session.setAttribute("message", "CREDENZIALI ERRATE");
			response.sendRedirect("./login.jsp");
		}
	}

}
