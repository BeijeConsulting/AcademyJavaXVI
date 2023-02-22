package it.beije.neumann.web.mongiello;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;





/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/mongiello/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Tutto completato ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("fkey");
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT c FROM Contatto as c WHERE id = :i");
		query.setParameter("i",Integer.parseInt(id));
		List<Contatto> contatti = query.getResultList();
		
		System.out.println(contatti);
		
		response.getWriter().append("<html><body><p>")
		.append("Nome: ").append(contatti.get(0).getName()).append("<br/>")
		.append("Congnome: ").append(contatti.get(0).getSurname())
		.append("</p></body></html>");
		
		//doGet(request, response);
	}

}
