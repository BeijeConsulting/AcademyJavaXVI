package it.beije.neumann.web.vanoli.rubricaWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/vanoli/duplicati")
public class DuplicatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	//la get trova i contatti duplicati
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Contatto> contatti = RubricaJPAWeb.trovaContattiDuplicati();
		session.setAttribute("contatti", contatti);
		response.sendRedirect("./duplicati.jsp");
	}

	//la post unisce i contatti duplicati
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RubricaJPAWeb.unisciContattiDuplicati();
		response.sendRedirect("./elenco");
	}

}
