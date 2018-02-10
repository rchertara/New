package application;

public class SongNode implements Comparable <SongNode>{

	String SongName;
	String ArtistName;
	String Album;
	String Year;
	//SongNode next;
	
	public SongNode(String SongName,String ArtistName){ //mandatory
		this.SongName=SongName;
		this.ArtistName=ArtistName;
		this.Album=null;
		this.Year=null;
		//this.next=null;
	}
		
	public SongNode(String SongName, String ArtistName, String Album, String Year) { //optional
		this.SongName=SongName;
		this.ArtistName=ArtistName;
		this.Album=Album;
		this.Year=Year;
	//	this.next=null;
		
		}
	

	   @Override
	   //these use the comparable method so we can use FX collections sort 
	   public int compareTo(SongNode otherSong) { //uses object compare
		   int ans=0;
		   
		   if ((this.SongName.toLowerCase().compareTo(otherSong.SongName.toLowerCase()))  == 0 ){ //uses string compare TO
		    
		    		if((this.ArtistName.toLowerCase().compareTo(otherSong.ArtistName.toLowerCase())) ==  0){
		    		ans=0;
		    		return ans;
		    		}
		    		
		    		else{
		    		ans=this.ArtistName.toLowerCase().compareTo(otherSong.ArtistName.toLowerCase());
		    		return ans;
		    		}
		    }
		    
		    else {
		    	ans=this.SongName.toLowerCase().compareTo(otherSong.SongName.toLowerCase());	
		    	return ans;
		    }
	   
	   }
	   

	   @Override
	   //
	   public boolean equals(Object songItem) {
	      if(this == songItem) {
	         return true;
	      }
	  //    this.getClass() != songItem.getClass())
	      else if(songItem == null || !(songItem instanceof SongNode)) {
	                                   
	      }
	      
	      else {

	      SongNode song = (SongNode) songItem;
	     // boolean ans=false;
	      boolean flag1= SongName.equals(song.SongName);
	    	  boolean flag2= ArtistName.equals(song.ArtistName);
	    	  return flag1&&flag2;
	   }
	 	  return false;
	  
	}
		

	   

public String getSongName() {
	return SongName;
}



public void setSongName(String songName) {
	SongName = songName;
}



public String getArtistName() {
	return ArtistName;
}



public void setArtistName(String artistName) {
	ArtistName = artistName;
}



public String getAlbum() {
	return Album;
}



public void setAlbum(String album) {
	Album = album;
}



public String getYear() {
	return Year;
}



public void setYear(String year) {
	Year = year;
}



public String toString() {

	String ans="";
	ans=this.SongName+"->"+this.ArtistName;
	return ans;
	
}



	
}
