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
public class inserisciContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserisciContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer id = 0;
		
		if(session.getAttribute("id")!=null) {
			//Trasformo l'id in integer dato che è object
			id = (Integer)session.getAttribute("id");
		}
		
		String nome = request.getParameter("nomecontatto");
		String cognome = request.getParameter("cognomecontatto");
		String telefono = request.getParameter("telefonocontatto");
		String email = request.getParameter("emailcontatto");
		String note = request.getParameter("notecontatto");

		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//Creo istanza contatti
		Contatti contatto = new Contatti();
		
		//Se è stata inserito almeno un elemento
		if(!nome.isEmpty() || !cognome.isEmpty() || !telefono.isEmpty() || !email.isEmpty() || !note.isEmpty()) {
			if(id > 0) { //Se abbiamo un id, significa che vogliamo "modificare" un contatto
				contatto = entityManager.find(Contatti.class, id); //Prendo il contatto da modificare e setto i vari parametri
				if(contatto != null) {
					contatto.setNome(nome);
					contatto.setCognome(cognome);
					contatto.setTelefono(telefono);
					contatto.setEmail(email);
					contatto.setNote(note);
					
					id = 0;  //Resetto id dopo aver modificato il contatto desiderato
					String modificaFalse = null;
					session.setAttribute("modificaButton", modificaFalse); //Resetto anche modificaButton così da leggere i contatti senza vedere ("inserisci id")
				} else {
					response.sendRedirect("./errore.jsp");
				}
			} else {  //Altrimenti vogliamo solo inserirne uno
				contatto.setNome(nome);
				contatto.setCognome(cognome);
				contatto.setTelefono(telefono);
				contatto.setEmail(email);
				contatto.setNote(note);
			}
		
			entityManager.persist(contatto);
			transaction.commit();
			
			//Leggo contatti
			Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
			List<Contatti> contattiLettura = query.getResultList();
			
			entityManager.close();
				
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
