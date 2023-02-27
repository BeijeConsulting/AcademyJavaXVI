package it.beije.neumann.web.verzaschi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InserisciContatto
 */
@WebServlet("/nicole/inserisciContatto")
public class InserisciContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		HttpSession session=request.getSession();
		String nome = request.getParameter("name");
		String cognome = request.getParameter("surname");
		String email=request.getParameter("email");
		String tell=request.getParameter("telephone");
		String note=request.getParameter("note");
		
		
		Contact contatto=new Contact();
		contatto.setName(nome);
		contatto.setSurname(cognome);
		contatto.setTelephone(tell);
		contatto.setEmail(email);
		contatto.setNote(note);
		
		GestoreContattiJPA.addContact(contatto);
		
		
		
		response.sendRedirect("./VisualizzaNuovoContatto.jsp");
		System.out.println("inserito");
		
	}

}
