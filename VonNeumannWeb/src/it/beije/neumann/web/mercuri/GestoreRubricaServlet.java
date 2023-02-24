package it.beije.neumann.web.mercuri;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GestoreRubricaServlet
 */
@WebServlet("/mercuri/rubrica")
public class GestoreRubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestoreRubricaServlet() {
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
		
		System.out.println("request " + request.getParameter("view"));
		System.out.println("request " + request.getParameter("order"));
		System.out.println("request " + request.getParameter("search"));
		
		if(session.getAttribute("search") == null)
			session.setAttribute("search", request.getParameter("search"));
		if(session.getAttribute("field") == null)
			session.setAttribute("field", request.getParameter("field"));
		if(session.getAttribute("value") == null)
			session.setAttribute("value", request.getParameter("value"));
		
		if(session.getAttribute("view") == null)
			session.setAttribute("view", request.getParameter("view"));		
		if(session.getAttribute("order") == null)
			session.setAttribute("order", request.getParameter("order"));
		
		if(session.getAttribute("order") != null) {
			List<Contatto> contatti = RubricaJPA.viewContatti((String) session.getAttribute("order"));
			session.setAttribute("contatti", contatti);
		}
		
		if(session.getAttribute("value") != null) {
			List<Contatto> contatti = RubricaJPA.searchContatto((String) session.getAttribute("field"),(String) session.getAttribute("value"));
			session.setAttribute("contatti", contatti);
		}
		response.sendRedirect("./GestoreRubrica.jsp");
		

		

	}

}
