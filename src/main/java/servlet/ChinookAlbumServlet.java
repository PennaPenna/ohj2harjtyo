package servlet;

import java.io.IOException;
import model.Album;
import database.AlbumDAO;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/album")
public class ChinookAlbumServlet extends HttpServlet {
	AlbumDAO albumDAO=new AlbumDAO();
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("!");
		int ArtistId = Integer.parseInt(request.getParameter("id"));
		String ArtistName = request.getParameter("name");
		List<Album> allAlbums=albumDAO.queryAll(ArtistId);
		request.setAttribute("allAlbums", allAlbums);
		request.setAttribute("ArtistName", ArtistName);
		request.getRequestDispatcher("/WEB-INF/album.jsp").forward(request, response);		
    }
	}