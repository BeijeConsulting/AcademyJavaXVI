package it.beije.neumann.web.vanoli.rubricaWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/vanoli/elenco")
public class ElencoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ord = request.getParameter("ord");
		HttpSession session = request.getSession();
		if (ord == null) {
			ord = "id";
		}
		List<Contatto> contatti = RubricaJPAWeb.elencoRubrica(ord);
		session.setAttribute("contatti", contatti);
		response.sendRedirect("./elenco.jsp");
	}

}
