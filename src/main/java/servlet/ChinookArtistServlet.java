package servlet;

import java.io.IOException;
import model.Artist;
import database.ArtistDAO;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/music")
public class ChinookArtistServlet extends HttpServlet {
	ArtistDAO listDao=new ArtistDAO();
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Artist> allArtists=listDao.queryAll();
		request.setAttribute("allArtists", allArtists);
		request.getRequestDispatcher("/WEB-INF/music.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String Name = request.getParameter("Name");
		Artist newArtist = new Artist(Name);
	       listDao.addArtist(newArtist);
	        response.sendRedirect("/music");
	}
	}
