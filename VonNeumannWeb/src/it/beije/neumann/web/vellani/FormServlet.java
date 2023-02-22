package it.beije.neumann.web.vellani;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/vellani/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        System.out.println("FormServlet...");
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
		
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//		
//		System.out.println("fname = " + fname);
//		System.out.println("lname = " + lname);
//		
//		response.getWriter().append("<html><body><p>")
//			.append("FNAME: ").append(fname).append("<br/>")
//			.append("LNAME: ").append(lname)
//			.append("</p></body></html>");
		
		String stringNum1 = request.getParameter("num1");
		String stringNum2 = request.getParameter("num2");
		
		Integer num1 = Integer.parseInt(stringNum1);
		Integer num2 = Integer.parseInt(stringNum2);
		
		Integer result = num1 + num2;
		
		response.getWriter().println("Il risultato della somma tra " + num1 + " e " +  num2 + " e' uguale a " + result);
		
	}

}
