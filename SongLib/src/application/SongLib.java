package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
	    primaryStage.setScene(new Scene(root, 850,650));
	   primaryStage.show();        
    
    }
    
    
   


}
