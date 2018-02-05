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
	public ArrayList<SongNode> getArrayList() {         
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
				System.out.println("added");
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
			
	}
	
	public void insertSong(SongNode newSong) {
		
		if(!arrayList.contains(newSong)){
			
			arrayList.add(newSong);
		
			Collections.sort(arrayList);
			
			return;
		
		}
		else return;
	}
	
	
	

}



//need to create a sorting method 

//public SongNode head=null;
	

//public void AddSong(String SongName, String ArtistName, String Album, String Year) {
//    
//	SongNode newSong= new SongNode(SongName,ArtistName,Album,Year);
//	newSong.next=head;
//	head=newSong;//insert to the front of the list 
//	
//	//call sorting method for every add 
//}
//
//public void deleteSong(String SongName, String ArtistName) {
//	SongNode curr;
//	SongNode prev=null;
//	int flag=0;
//	for(curr=head;curr!=null;curr=curr.next){
//	
//		if(curr.SongName==SongName && curr.ArtistName==ArtistName) {
//			prev.next=curr.next;
//			flag++;
//		}
//		else {
//			prev=curr;
//		}
//		
//     }
//	
//	if(flag==1) {
//		//call sorting method
//	}
//
//}
//
//}
