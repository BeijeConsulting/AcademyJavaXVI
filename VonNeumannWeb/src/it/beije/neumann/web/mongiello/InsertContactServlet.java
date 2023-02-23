package it.beije.neumann.web.mongiello;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertContactServlet
 */
@WebServlet("/mongiello/InsertContactServlet")
public class InsertContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String telelphone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		
		EntityManager entityManager = JPAentityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Contatto contatto = new Contatto( name,surname,telelphone,email,note );
		transaction.begin();
		entityManager.persist(contatto);
		transaction.commit();
		entityManager.close();
		
		session.setAttribute("message", "Valore Inserito correttamente");
		response.sendRedirect("./insertContactForm.jsp");
		
		
	}

}
