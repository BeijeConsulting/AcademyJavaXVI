package it.beije.neumann.web.vanoli.rubricaWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/vanoli/api/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Contatto c = new Contatto();
		c.setId((Integer)session.getAttribute("id"));
		c.setNome(request.getParameter("nome"));
		c.setCognome(request.getParameter("cognome"));
		c.setTelefono(request.getParameter("telefono"));
		c.setEmail(request.getParameter("email"));
		c.setNote(request.getParameter("note"));
		RubricaJPAWeb.editContatto(c);
		response.sendRedirect("../elenco.jsp");
	}

}
