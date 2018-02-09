package application;
import java.io.BufferedReader;
import javafx.scene.control.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongLibrary {
	
	//public songList<SongNode> arrayList;
	ObservableList<SongNode> songList;
	
	public SongLibrary() {
		//this.songList=FXCollections.observablesongList();
		 // this.songList= new songList<SongNode>();
		  this.songList = FXCollections.observableArrayList();
		 
		
	}
	public ObservableList<SongNode> getsongList() {  //still not sure if i need this        
		    return this.songList;     
    }    
	
	public ObservableList<SongNode> sortAscending() {         
		    FXCollections.sort(this.songList);         
		    return this.songList;     
	}       
	 public void print() {
	    	
	      	for (int i = 0; i < this.songList.size(); i++) {
	            SongNode val =this.songList.get(i);
	            
	            System.out.println(val.SongName+"-->"+val.ArtistName);
	        }
	     	 
	    }
	public void parse(){
		String text="";
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader("C:\\Users\\avocado\\Desktop\\Rutgers\\Spring 2018\\Software Methodology\\Projects\\Song_lib\\src\\application\\hate.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	      
			try {
				while((text=buffer.readLine())!=null) {
				String textArray[]= new String[4];
				
				String temp[]= text.split(",");
				
				for(int i=0;i<temp.length;i++) {
					textArray[i]=temp[i];
				}
					
				SongNode newNode=new SongNode(textArray[0],textArray[1],textArray[2],textArray[3]);	
				
			//MUST MAKE A CATCH HERE FOR if songs are dupliate 
				this.songList.add(newNode);
			
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
			
	}
	
	public void Add(SongNode newSong) {
		
		if(!songList.contains(newSong)){
		
			
			songList.add(newSong);
		    
			FXCollections.sort(songList);// for each add you must put in correct spot
		    //could you binary search to find correct spot but much easier
			
			return;
		}
		
		else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "Song already in list.", ButtonType.OK);
			alert.showAndWait();
			 return;
		}
	
	
	}
	
	
	public void Delete(String SongName, String ArtistName) {
		
		for (int i = 0; i < songList.size(); i++) {
            SongNode node =songList.get(i);
           if(node.getSongName()==SongName && node.getArtistName()==ArtistName) {
        	   songList.remove(i);
        	   return;
           }
           else {
        	   continue;
           }
            
        }
		
		FXCollections.sort(songList);
		return;
		
		
	}
	
	public void Edit(String currSong,String currArtist, String newName, String newArtist, String newAlb, String newYear) {
		
 
		SongNode target= new SongNode(newName,newArtist,newAlb,newYear);
	
		int targetIndex= songList.indexOf(target);
      
			if(targetIndex==-1) {
			
				for (int i = 0; i < songList.size(); i++) {
			    SongNode node =songList.get(i);
				if(node.getSongName()==currSong && node.getArtistName()==currArtist) {
       
					songList.remove(i);
					songList.add(target);
					
//					node.setSongName(newName);
//					node.setArtistName(newArtist);
//					node.setAlbum(newAlb);
//					node.setYear(newYear);
        	   
					
					
					
					FXCollections.sort(songList);
					return;
				}
           
				else {
					continue;
				}
            
				}
		
		 }
			
			else {
				Alert alert = new Alert(Alert.AlertType.WARNING, "Song already in list. Edit cannot be made.", ButtonType.OK);
				alert.showAndWait();
				return;
			}
	
	
	}
	
	
	
}
	
	


