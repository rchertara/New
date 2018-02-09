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
	
	
	public static void main(String[] args) {
      	 launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
	    Parent root = FXMLLoader.load(getClass().getResource("songLib_layout.fxml"));
	    FXMLLoader loader = new FXMLLoader();
	    Controller listController = loader.getController();
	    primaryStage.setTitle("Song Library");
	    primaryStage.setScene(new Scene(root, 808,624));
	    primaryStage.show();        
    
    }
    
    
    public void addClicked() {
    	System.out.println("Add Button Clicked");
    }


}
