package model;

public class Album {

	private int AlbumId;
	private int ArtistId;
    private String Title;

    public Album(int ArtistId, int AlbumId, String Title) {
        this.ArtistId = ArtistId;
        this.AlbumId = AlbumId;
        this.Title = Title;
    }
    public Album(int AlbumId, String Title) {
        this.AlbumId = AlbumId;
        this.Title = Title;
    }

    public Album(String Title) {
        this.Title = Title;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int ArtistId) {
        this.ArtistId = ArtistId;
    }

    public String getTitle() {
        return Title;
    }

    public int getAlbumId() {
		return AlbumId;
	}

	public void setAlbumId(int albumId) {
		AlbumId = albumId;
	}

	public String toString(){//overriding the toString() method  
    	  return AlbumId+" "+Title;  
    	 }  
    
    @Override
    public boolean equals(Object other) {
        return other instanceof Album && ((Album) other).AlbumId == this.AlbumId;
    }
    
}