package it.beije.neumann.web.mongiello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class choicheContactToEditServlet
 */
@WebServlet("/mongiello/choicheContactToEditServlet")
public class choicheContactToEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public choicheContactToEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Contatto toEdit = (Contatto) session.getAttribute("contact");
		//System.out.println(toEdit.getId());
		
		String id = request.getParameter("contactToEdit");
		
		List<Contatto> contatti = new ArrayList<>();
		contatti = (List<Contatto>) session.getAttribute("contatti");
		
		Contatto c = Contatto.getContactById(contatti, Integer.parseInt(id));

		session.setAttribute("contattoToEdit", c);
		
		response.sendRedirect( "./confirmEdit.jsp" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
