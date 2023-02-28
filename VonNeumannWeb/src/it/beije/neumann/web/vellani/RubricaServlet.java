package it.beije.neumann.web.vellani;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/vellani/RubricaServlet")
public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RubricaServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	String action = request.getParameter("action");
		HttpSession session = request.getSession();
        EntityManager entityManager = RubricaEntityManager.getEntityManager();
        
        switch (action) {
            case "vediListaContatti":
            	Query query = entityManager.createQuery("SELECT c FROM Contatto c");
            	List<Contatto> contatti = (List<Contatto>) query.getResultList();
                session.setAttribute("contatti", contatti);
                response.sendRedirect("Rubrica.jsp");
                break;
                
            case "cercaContatto":
            	String stringaRicerca = request.getParameter("stringaRicerca");
                Query queryRicerca = entityManager.createQuery("SELECT c FROM Contatto c WHERE c.name LIKE :stringaRicerca");
                queryRicerca.setParameter("stringaRicerca", "%" + stringaRicerca + "%");
                List<Contatto> contattiRicerca = (List<Contatto>) queryRicerca.getResultList();
                session.setAttribute("contatti", contattiRicerca);
                response.sendRedirect("CercaContatto.jsp");
            	
            	
                break;
                
            case "inserisciContatto":
                break;
                
            case "modificaContatto":
                break;
                
            case "cancellaContatto":
                
                break;
                
            case "unisciContattiDuplicati":
                break;
            case "esci":
                break;
         } 
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

}
