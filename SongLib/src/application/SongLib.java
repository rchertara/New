package application;
	
//import Controller.java;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;




public class SongLib extends Application {
	//public ArrayList<SongNode> arrayList;
	//private SongLibrary SongList;
	
    public static void main(String[] args) {
      	
      	
      	 
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
    	//SongLibrary library = new SongLibrary();
  	//library.parse();
    	
    	
    	
    	SongLibrary library = new SongLibrary();
      	library.parse();
      	library.sortAscending();
      	
      	for (int i = 0; i < library.songList.size(); i++) {
             SongNode val =library.songList.get(i);
             String value=val.SongName;
             //System.out.println("Element: " + value);
         }
      	 
   
    	

       
  
    //List stuff
    
    //make list view
    
   // ListView<SongNode> listView = new ListView<>();
   

    //listView.setItems(library.getsongList());
      	
		
    //library.print();
    Parent root = FXMLLoader.load(getClass().getResource("songLib_layout.fxml"));
    FXMLLoader loader = new FXMLLoader();
    Controller listController = loader.getController();
   
    listController.initialize(library);
    
    
    primaryStage.setTitle("Song Library");
    primaryStage.setScene(new Scene(root, 688, 502));
    primaryStage.show();        
    
    }//start method done
    
    
    public void addClicked() {
    	
    	System.out.println("Add Button Clicked");
    }


}
