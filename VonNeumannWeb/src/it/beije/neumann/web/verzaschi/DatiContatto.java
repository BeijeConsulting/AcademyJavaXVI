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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		
		HttpSession session=request.getSession();
		String nome = request.getParameter("name");
		String cognome = request.getParameter("surname");
		
		List<Contact> eliminati=GestoreContattiJPA.cancellaContatto(nome, cognome);
		
		session.setAttribute("contatti", eliminati);
		response.sendRedirect("./ContattoEliminato.jsp");
		System.out.println("eliminato");
		
	}

}
