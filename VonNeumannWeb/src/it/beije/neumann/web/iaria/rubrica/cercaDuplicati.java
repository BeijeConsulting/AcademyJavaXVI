package it.beije.neumann.web.iaria.rubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cercaDuplicati
 */
@WebServlet("/iaria/cercaDuplicati")
public class cercaDuplicati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cercaDuplicati() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rigaLetta = 0;
		int rigaLetta2 = 0;
		int duplicatiTrovati = 0;
		List<Contatti> contattiDuplicati = new ArrayList<>();
		Contatti duplicato = null;
		
		HttpSession session = request.getSession();
		
		String duplicatiTrue = request.getParameter("searchDuplicate");
		session.setAttribute("searchDuplicate", duplicatiTrue);
		
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query queryLettura = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contattiLetti = queryLettura.getResultList();
		
		for (Contatti c : contattiLetti) {
			rigaLetta++;
			for(Contatti c2 : contattiLetti) {
				rigaLetta2++;
				if(rigaLetta != rigaLetta2) {
					if(c2.getCognome().contains(c.getCognome()) && c2.getNome().contains(c.getNome())) {
						duplicato = new Contatti();
						duplicatiTrovati++;
						duplicato.setNome(c2.getNome());
						duplicato.setCognome(c2.getCognome());
						duplicato.setEmail(c2.getEmail());
						duplicato.setId(c2.getId());
						duplicato.setNote(c2.getNote());
						duplicato.setTelefono(c2.getTelefono());
						contattiDuplicati.add(duplicato);
						//System.out.println(c2.getNome()+" "+c2.getCognome()+" ha un duplicato alla riga: "+rigaLetta2);
					}
				}
			}
			rigaLetta2 = 0; 
			if(duplicatiTrovati != 0) {
				duplicatiTrovati = 0;
			}
		}
		
		entityManager.close();
		
		session.setAttribute("contatti", contattiDuplicati);
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
