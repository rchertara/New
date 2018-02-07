package application;
	

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
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
      	
      	for (int i = 0; i < library.arrayList.size(); i++) {
             SongNode val =library.arrayList.get(i);
             String value=val.SongName;
             System.out.println("Element: " + value);
         }
      	 
   
    	

       
  
    //List stuff
    
    //make list view
    
    ListView<SongNode> listView = new ListView<>();
    ObservableList<SongNode> myObservableList = FXCollections.observableList(library.arrayList);
    listView.setItems(myObservableList);
    
    listView.setCellFactory(new Callback<ListView<SongNode>, ListCell<SongNode>>(){
    	 
        @Override
        public ListCell<SongNode> call(ListView<SongNode> p) {
             
            ListCell<SongNode> cell = new ListCell<SongNode>(){

                @Override
                protected void updateItem(SongNode t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.getSongName());
                    }
                }

            };
             
            return cell;
        }
    });

    Parent root = FXMLLoader.load(getClass().getResource("songLib_layout.fxml"));
    primaryStage.setTitle("Song Library");
    primaryStage.setScene(new Scene(root, 688, 502));
    primaryStage.show();        
    
    }//start method done
    
    
    public void addClicked() {
    	
    	System.out.println("Add Button Clicked");
    }


}
