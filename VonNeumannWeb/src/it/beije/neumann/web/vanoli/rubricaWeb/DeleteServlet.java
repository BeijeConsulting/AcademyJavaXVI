package it.beije.neumann.web.vanoli.rubricaWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/vanoli/api/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Contatto c = (Contatto) session.getAttribute("contatto");
		RubricaJPAWeb.deleteContatto(c);
		response.sendRedirect("../elenco");
	}

}
