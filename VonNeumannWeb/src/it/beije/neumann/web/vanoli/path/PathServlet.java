package it.beije.neumann.web.vanoli.path;

import java.io.File;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vanoli/path")
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PathServlet() {
        super();
        System.out.println("PathServlet...");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		File dir = new File(path);
		if (!dir.exists() || !dir.isDirectory()) {
			response.getWriter().append("<html><body><p>").append("Il file non esiste o non è una directory!").append("</p></body></html>");
		}
		StringBuilder result = new StringBuilder(); 
		PathFinder.listDirectoryContents(new File(path), result, "");
		response.getWriter().append("<html><body><p>").append(result.toString()).append("</p></body></html>");
	}

}
