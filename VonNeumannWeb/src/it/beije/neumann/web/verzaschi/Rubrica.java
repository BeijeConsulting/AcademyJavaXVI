package it.beije.neumann.web.verzaschi;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Rubrica
 */
@WebServlet("/nicole/rubrica")
public class Rubrica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rubrica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		HttpSession session=request.getSession();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		switch(action) {
		case("Cerca contatto"):
			List<Contact> contatti= GestoreContattiJPA.vediListaContatti();
		session.setAttribute("contactss", contatti);
		response.sendRedirect("./RubricaJSP.jsp");
		
		case("Visualizza contatti duplicati"):
			List<Contact> contatti2=GestoreContattiJPA.vediListaDuplicati();
		session.setAttribute("contactss", contatti2);
		response.sendRedirect("./RubricaJSP.jsp");
		case("Cancella contatto"): 
			List<Contact> eliminati=GestoreContattiJPA.cancellaContatto(action, action);
			response.sendRedirect("./InsertContact.jsp");
		
		
		}
	
	
		
	
		transaction.commit();
		entityManager.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request,response);
		
		
		
	}

}
