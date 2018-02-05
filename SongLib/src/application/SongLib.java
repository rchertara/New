package application;
	

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SongLib extends Application {
	public ArrayList<SongNode> arrayList;
	private SongLibrary SongList;
	
    public static void main(String[] args) {
      	SongLibrary library = new SongLibrary();
      	library.parse();
      	library.sortAscending();
      	
      	for (int i = 0; i < library.arrayList.size(); i++) {
             SongNode val =library.arrayList.get(i);
             String value=val.SongName;
             System.out.println("Element: " + value);
         }
      	 
      	
      	 
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    	//SongLibrary library = new SongLibrary();
  	//library.parse();
    	
    	
    	
    	  Parent root = FXMLLoader.load(getClass().getResource("songLib_layout.fxml"));
       primaryStage.setTitle("Song Library");
        primaryStage.setScene(new Scene(root, 688, 502));
       primaryStage.show();
       
        
        
    
    }//start method done
    
    
    public void addClicked() {
    	
    	System.out.println("Add Button Clicked");
    }


}
