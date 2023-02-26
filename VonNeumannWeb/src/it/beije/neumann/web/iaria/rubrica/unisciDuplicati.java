package it.beije.neumann.web.iaria.rubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class unisciDuplicati
 */
@WebServlet("/iaria/unisciDuplicati")
public class unisciDuplicati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public unisciDuplicati() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean haDuplicato = false;
		Contatti contatto = null;
		
		HttpSession session = request.getSession();
		
		String idContatto = request.getParameter("idcontatto");
		int id = Integer.parseInt(idContatto);
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//Seleziono contatto con id corrispondente
		contatto = entityManager.find(Contatti.class, id);
		
		Query queryLettura = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contattiLetti = queryLettura.getResultList();
		for(Contatti c : contattiLetti) { //Se nome e cognome corrispondono e l'id è diverso da quello inserito (così non cancello l'utente originale)
			if(c.getNome().contains(contatto.getNome()) && c.getCognome().contains(contatto.getCognome()) && c.getId() != contatto.getId()) {
				haDuplicato = true;
				contatto.setTelefono(contatto.getTelefono() + " / " + c.getTelefono());
				entityManager.persist(contatto);
				entityManager.remove(c);
			} //Aggiungo i numeri di telefono all'utente originale ed elimino gli altri
		}
		
		if(haDuplicato == false) {
			response.getWriter().append("<html><body><p>").append("Nessuna corrispondenza!").append("</p></body></html>");
		}
		
		id = 0;  //Resetto id dopo aver eliminato il contatto desiderato
		String unisciFalse = null;
		session.setAttribute("mergeDuplicate", unisciFalse); //Resetto anche deleteContact così da leggere i contatti senza vedere ("inserisci id")
		
		//Aggiorno la lista dei contatti per poi stamparla
		Query query2 = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contatti = query2.getResultList();
		
		transaction.commit();
		entityManager.close();
		
		session.setAttribute("contatti", contattiLetti);
		response.sendRedirect("./listaContatti.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
