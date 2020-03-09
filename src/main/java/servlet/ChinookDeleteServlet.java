package servlet;

import java.io.IOException;
import database.ArtistDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChinookDeleteServlet")
public class ChinookDeleteServlet extends HttpServlet {
	ArtistDAO artistDAO=new ArtistDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Poistetaan!");
		int ArtistId = Integer.parseInt(request.getParameter("id"));
		artistDAO.removeArtistId(ArtistId);
		response.sendRedirect("/music");
	}
}
