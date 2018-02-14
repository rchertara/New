package application;
import java.io.BufferedReader;


import javafx.scene.control.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongLibrary {
	
	   private final static String fileName ="test.txt";//Name of the song data!
		
	   /*@authors
	    * Rahil Chertara
	    * Avantika Yellapantula
	    * */
	
	//public songList<SongNode> arrayList;
	ObservableList<SongNode> songList;
	
	
 
	public SongLibrary() {
	 	  //this.songList=FXCollections.observablesongList();
		 // this.songList= new songList<SongNode>();
		  this.songList = FXCollections.observableArrayList();
		 
		
	}
	public ObservableList<SongNode> getsongList() { //still not sure if i need this        
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
			buffer = new BufferedReader(new FileReader("src/application/"+fileName));
		}catch(FileNotFoundException e){
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
				
				if(textArray[0]==null||textArray[1]==null) {
					continue;
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
		public void toFile() {
		
		Writer writer = null;
				try {
					writer = new FileWriter("src/application/"+fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	//
	        	for(int i=0;i<songList.size();i++) {
	        		SongNode node=songList.get(i);
	        		
	        		String line= node.toText();
	        		try {
						writer.write(line);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		
	        	}
	        		
	        		
	        		try {
					writer.close();
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
	        
	      
		}
	
	
	
	
	public void Add(SongNode newSong) {
     
		boolean flag=true;
		String lowerSong=newSong.SongName.toLowerCase();
		String lowerArtist=newSong.ArtistName.toLowerCase();
		
		for(SongNode i: songList) {
			
			if(lowerSong.equals(i.SongName.toLowerCase())&& lowerArtist.equals(i.ArtistName.toLowerCase())){
				
				flag=false;
			
			}
			
			else {
				continue;
			}
			
			
		}
		
		if(flag==true) {
			songList.add(newSong);
		    
			FXCollections.sort(songList);
			return;
		}
		
		else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "Song already in list.", ButtonType.OK);
			alert.showAndWait();
			 return;
		}
		
		
	/*
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
	*/
	
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
	
	public void Edit(SongNode song, String newName, String newArtist, String newAlb, String newYear) {
		
 
		
	    if(song.SongName.equals(newName)&&song.ArtistName.equals(newArtist)) {
	    	song.setAlbum(newAlb);
	    	song.setYear(newYear);
	    	return;
	    }
	    
	    
	    String lowerSong=newName.toLowerCase();
	    String lowerArtist=newArtist.toLowerCase();
	    
	    
	   boolean flag=true; //assume not in list 
	   
	   for(SongNode i :songList) {
		   
		   
		   if(i.SongName.toLowerCase().equals(lowerSong) && i.ArtistName.toLowerCase().equals(lowerArtist)) {
			   
			   flag=false;
			   
		   }
		   
	}
	   
	   
	   if(flag==false) {
		   Alert alert = new Alert(Alert.AlertType.WARNING, "Song already in list. Edit cannot be made.", ButtonType.OK);
			alert.showAndWait();
			return;
	   }
	   
	   else {
		   
		   
		   SongNode newNode= new SongNode(newName,newArtist,newAlb,newYear);
		   songList.add(newNode); //reg add
		   FXCollections.sort(songList);
		   return;
		   
	   }
	    
	    
	    
	   
	    /*
		
	    SongNode target= new SongNode(newName,newArtist,newAlb,newYear);
		
	    int targetIndex= songList.indexOf(target);
		
	
			if(targetIndex==-1) {
			
				for (int i = 0; i < songList.size(); i++) {
			    SongNode node =songList.get(i);
				if(node.getSongName()==song.SongName && node.getArtistName()==song.ArtistName) {
       
				
					songList.remove(i);
					Add(target);
			
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
	*/
	
	}
	
	

	
	

}
	
	


