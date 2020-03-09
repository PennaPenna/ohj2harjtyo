package database;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Album;
import model.Artist;

public class AlbumDAO {
	private Connection con=null;
	private ResultSet rs = null;
	private PreparedStatement preparedStatement=null; 
	private String sql;
	String title="";
	 int id=0;
	 int maxid=0;
	
	    public Connection connect() {
	    	Connection con = null; 
	    	String SQLITE_FILE= new File("src/main/java/database/Chinook_Sqlite.sqlite").getAbsolutePath(); 
	    	String url = "jdbc:sqlite:"+ SQLITE_FILE;	    	    	
    	try {
    		Class.forName("org.sqlite.JDBC");
	         con = DriverManager.getConnection(url);	        
	     }catch (Exception e){	         
	        e.printStackTrace();	         
	     }
	     return con;
	}
    	//QUERY for all ALBUMS by ARTIST
		public List<Album> queryAll(int ArtistId) {
			List<Album> allAlbums = new ArrayList<>();
            sql = "SELECT * FROM Album WHERE ArtistId=?";
            try {
				con=connect();
				if(con!=null){ //yhteys onnistui
					preparedStatement = con.prepareStatement(sql);  
					preparedStatement=con.prepareStatement(sql);  
					preparedStatement.setInt(1, ArtistId);			
	        		rs = preparedStatement.executeQuery();   
						while(rs.next()){
							int AlbumId= rs.getInt("AlbumId");
							String Title= rs.getString("Title");
							Album newAlbum = new Album(ArtistId, AlbumId, Title);	
							allAlbums.add(newAlbum);
						}			
					}
					else {
						 System.out.println("RS FAIL");
						 
					}con.close();						
			} catch (Exception e) {
				e.printStackTrace();
			}	
	return allAlbums;
	} 
		 }
            
       