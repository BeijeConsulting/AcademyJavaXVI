package it.beije.neumann.web.iaria.rubrica;

import java.io.IOException;
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
 * Servlet implementation class leggiContatti
 */
@WebServlet("/iaria/inserisciContatti")
public class inserisciContatti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserisciContatti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nome = request.getParameter("nomecontatto");
		String cognome = request.getParameter("cognomecontatto");
		String telefono = request.getParameter("telefonocontatto");
		String email = request.getParameter("emailcontatto");
		String note = request.getParameter("notecontatto");

		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//Inserisco contatti
		Contatti contatti = new Contatti();
		//Almeno una riga piena
		if(!nome.isEmpty() || !cognome.isEmpty() || !telefono.isEmpty() || !email.isEmpty() || !note.isEmpty()) {
			contatti.setNome(nome);
			contatti.setCognome(cognome);
			contatti.setTelefono(telefono);
			contatti.setEmail(email);
			contatti.setNote(note);
		
			entityManager.persist(contatti);
			transaction.commit();
			
			//Leggo contatti
			Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
			List<Contatti> contattiLettura = query.getResultList();
			
			entityManager.close();
			System.out.println("Contatto salvato con successo!");
				
			session.setAttribute("contatti", contattiLettura);
			response.sendRedirect("./listaContatti.jsp");
		} else {
			response.sendRedirect("./errore.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
