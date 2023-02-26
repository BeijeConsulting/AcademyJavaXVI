package it.beije.neumann.web.verzaschi;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.*;

/**
 * Servlet implementation class DatiContatto
 */
@WebServlet("/nicole/datiContatto")
public class DatiContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatiContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("VonNeumannWeb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contact contatto= new Contact();
		
		
		String name = request.getParameter("Name");
		String surname = request.getParameter("Surname");
		
		List<Contact> contatti=GestoreContattiJPA.vediListaContatti();
		
		System.out.println("Name = " + name);
		System.out.println("Surname = " + surname);
		
		for(Contact c : contatti)
		{
			if(c.getName().equals(name))
			{
				if(c.getSurname().equals(surname)) contatto=c;
			}
		}
		
		entityManager.remove(contatto);
		transaction.commit();
		entityManager.close();
		response.sendRedirect("./InsertContact.jsp");
		
	}

}
