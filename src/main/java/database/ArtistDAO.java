package database;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Artist;

public class ArtistDAO {
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
    	//QUERY for all ARTISTS
		public List<Artist> queryAll() {
			List<Artist> allArtists = new ArrayList<>();
            sql = "SELECT * FROM Artist";
            try {
				con=connect();
				if(con!=null){ //yhteys onnistui
					preparedStatement = con.prepareStatement(sql);        		
	        		rs = preparedStatement.executeQuery();   
					if(rs!=null){ //kysely tuotti tuloksen	
						 System.out.println("RS SUCCESS");
						while(rs.next()){
							int ArtistId= rs.getInt("ArtistId");
							String Name= rs.getString("Name");
							Artist newArtist = new Artist(ArtistId,Name);	
							allArtists.add(newArtist);
	                        }					
					}
					else {
						 System.out.println("RS FAIL");
						 
					}con.close();			
				}			
			} catch (Exception e) {
				e.printStackTrace();
			}	
	return allArtists;
	}
		
		
		public boolean addArtist(Artist newArtist) {
			boolean success = false;
			sql="insert into Artist (Name) values (?)";						  
			try {
				con = connect();
				preparedStatement=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
				preparedStatement.setString(1, newArtist.getName());
				int rows=preparedStatement.executeUpdate();
				if (rows == 1) {
	                int generatedKey = preparedStatement.getGeneratedKeys().getInt(1);
	                newArtist.setArtistId(generatedKey);

	                success = true;
	            }
		        con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
				
			}				
			return success;
		}
		public boolean removeArtistId(int ArtistId) {
			boolean success = false;
			sql="DELETE FROM Artist WHERE ArtistId=?";		  
			try {
				con = connect();
				preparedStatement=con.prepareStatement(sql);  
				preparedStatement.setInt(1, ArtistId);			
				int rows=preparedStatement.executeUpdate();
				if (rows == 0) {
					success=true;
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}		
			return success;		
		} 
			
		}    
            
       