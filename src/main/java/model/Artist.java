package model;

public class Artist {

    private int ArtistId;
    private String Name;

    public Artist(int ArtistId, String Name) {
        this.ArtistId = ArtistId;
        this.Name = Name;
    }

    public Artist(String Name) {
        this.Name = Name;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int ArtistId) {
        this.ArtistId = ArtistId;
    }

    public String getName() {
        return Name;
    }

    
    public String toString(){//overriding the toString() method  
    	  return ArtistId+" "+Name;  
    	 }  
    
    @Override
    public boolean equals(Object other) {
        return other instanceof Artist && ((Artist) other).ArtistId == this.ArtistId;
    }
    
}