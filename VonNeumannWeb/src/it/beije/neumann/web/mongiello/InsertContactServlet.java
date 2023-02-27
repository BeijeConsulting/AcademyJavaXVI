package it.beije.neumann.web.mongiello;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertContactServlet
 */
@WebServlet("/mongiello/InsertContactServlet")
public class InsertContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertContactServlet() {
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
	
		HttpSession session = request.getSession();
		
//		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
//		EntityTransaction transaction = entityManager.getTransaction();
//		Contatto newContact = (Contatto) session.getAttribute("nuovoContatto");
//		transaction.begin();
//		entityManager.persist(newContact);
//		transaction.commit();
//		entityManager.close();
		
		RubricaJPA rubricaJpa = new RubricaJPA();
		Contatto newContact = (Contatto) session.getAttribute("nuovoContatto");
		rubricaJpa.inserisciContatto(newContact);
		request.getSession().removeAttribute("nuovoContatto");
		
		session.setAttribute("message", "Contatto inserito correttamente");
		response.sendRedirect("./insertContactForm.jsp");		
	}

}
