package it.beije.neumann.web.iaria.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
 * Servlet implementation class leggiContatti
 */
@WebServlet("/iaria/esportaCSV")
public class esportaCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public esportaCSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
				
		EntityManagerFactory entityManagerFactory = JPAEntityManager.openEntityManager();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String pathFile = "/Users/gianf/Desktop/contatti.csv";
		String separator = ";";
		File rubrica = new File(pathFile);
		boolean exists = rubrica.exists(); //File esiste
		FileWriter fileWriter = new FileWriter(pathFile, true);
		int righeInserite = 0;
			
		if(!exists) {//Creo la prima riga con NOME-COGNOME-NOTE-TELEFONO se il file non esiste
			fileWriter.write("ID" + separator);
			fileWriter.write("COGNOME" + separator);
			fileWriter.write("NOME" + separator);
			fileWriter.write("TELEFONO" + separator);
			fileWriter.write("EMAIL" + separator);
			fileWriter.write("NOTE" + "\n");
		}
		
		//Prendo i dati dal db
		Query query = entityManager.createQuery("SELECT c FROM Contatti as c");
		List<Contatti> contatti = query.getResultList();
		for (Contatti c : contatti) {
			righeInserite++;
			fileWriter.write(c.getId() + separator);
			fileWriter.write(c.getCognome() + separator);
			fileWriter.write(c.getNome() + separator);	
			fileWriter.write(c.getTelefono() + separator);
			fileWriter.write(c.getEmail() + separator);
			fileWriter.write(c.getNote() + "\n");
		}
		
		response.getWriter().append("<html><body><p>").append("Sono state inserite: "+righeInserite+" righe").append("</p></body></html>");

		fileWriter.close(); //Chiudo il file e salvo le modifiche

		entityManager.close();

		System.out.println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
