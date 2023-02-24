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
@WebServlet("/iaria/eliminaContatto")
public class eliminaContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminaContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String idContatto = request.getParameter("idcontatto");
		int id = Integer.parseInt(idContatto);
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//Elimino il contatto selezionato dall'utente
		//Query query = entityManager.createQuery("SELECT c FROM Contatti as c WHERE id = :id");
		//query.setParameter("id",id);
		Contatti contatto = new Contatti();
		contatto = entityManager.find(Contatti.class, id);
		if(contatto != null) {
			System.out.println(contatto);
			entityManager.remove(contatto);
		} else {
			response.sendRedirect("./errore.jsp");
		}
		
		System.out.println(contatto);
		
		id = 0;  //Resetto id dopo aver modificato il contatto desiderato
		String eliminaFalse = null;
		session.setAttribute("deleteContact", eliminaFalse); //Resetto anche modificaButton così da leggere i contatti senza vedere ("inserisci id")
		
		//Aggiorno la lista dei contatti per poi stamparla
		Query query2 = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contatti = query2.getResultList();
		
		transaction.commit();
		entityManager.close();
		
		session.setAttribute("contatti", contatti);
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
