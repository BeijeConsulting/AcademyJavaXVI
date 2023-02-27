package it.beije.neumann.web.iaria.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
@WebServlet("/iaria/importaCSV")
public class importaCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public importaCSV() {
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
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		int righeInserite = 0;
		String[] fields = null;
		Contatti contatto = null;
		String r = null;
		String pathFile = "/Users/gianf/Desktop/contatti.csv";
		String separator = ";";
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
			
		while (bufferedReader.ready()) {
			r = bufferedReader.readLine();
			fields = r.split(separator);
			
			righeInserite++;
			contatto = new Contatti();
			
			contatto.setCognome(fields[1]);
			contatto.setNome(fields[2]);
			contatto.setTelefono(fields[3]);
			contatto.setEmail(fields[4]);
			contatto.setNote(fields[5]);
			
			//Se si trova alla seconda riga (quindi salto NOME;COGNOME;TELEFONO;EMAIL;NOTE)
			if(righeInserite > 1) {
				entityManager.persist(contatto);
			}
			
			//session.save("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");

		}
			
			//Salto NOME;COGNOME;TELEFONO;EMAIL;NOTE togliendo 1 da righeInserite che contiene il numero di cicli effettuati
			response.getWriter().append("<html><body><p>").append("Sono state inserite: "+(righeInserite--)+" righe").append("</p></body></html>");
			
			bufferedReader.close();
			
			transaction.commit();
			entityManager.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
