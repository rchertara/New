package application;
import java.io.BufferedReader;
import java.util.ArrayList; 
import java.util.Collections;   
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongLibrary {
	
	public ArrayList<SongNode> arrayList;
	//ObservableList  <SongNode> songList;
	
	public SongLibrary() {
		//this.songList=FXCollections.observableArrayList();
		  this.arrayList= new ArrayList<SongNode>();
		 
		
	}
	public ArrayList<SongNode> getArrayList() {  //still not sure if i need this        
		    return this.arrayList;     
    }    
	
	public ArrayList<SongNode> sortAscending() {         
		    Collections.sort(this.arrayList);         
		    return this.arrayList;     
	}       
	
	public void parse(){
		String text="";
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader("src/application/hate.txt"));
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
				
			
				this.arrayList.add(newNode);
			//	System.out.println("added");
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
			
	}
	
	public void Add(SongNode newSong) {
		
		if(!arrayList.contains(newSong)){
		
			
			arrayList.add(newSong);
		
			Collections.sort(arrayList);// for each add you must put in correct spot
		    //could you binary search to find correct spot but much easier
			
			return;
		}
		
		else {
			System.out.print("already in library!");
			return;
		}
	
	
	}
	
	
	public void Delete(String SongName, String ArtistName) {
		
		for (int i = 0; i < arrayList.size(); i++) {
            SongNode node =arrayList.get(i);
           if(node.getSongName()==SongName && node.getArtistName()==ArtistName) {
        	   arrayList.remove(i);
        	   return;
           }
           else {
        	   continue;
           }
            
        }
		
		Collections.sort(arrayList);
		
		
	}
	
	public void Edit(String currSong,String currArtist, String newName, String newArtist, String newAlb, String newYear) {
		
		
		 
		
		for (int i = 0; i < arrayList.size(); i++) {
            SongNode node =arrayList.get(i);
           if(node.getSongName()==currSong && node.getArtistName()==currArtist) {
       
        	       node.setSongName(newName);
        	       node.setArtistName(newArtist);
        	       node.setAlbum(newAlb);
        	       node.setYear(newYear);
        	   
        	   }
           
           else {
        	   continue;
           }
            
        }
		
		 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}


