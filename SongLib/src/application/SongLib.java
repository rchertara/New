package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SongLib extends Application {
	//Rahil Chertara 
	Stage window;
	public static void main(String[] args) {
      	 launch(args);
    }
	


    @Override
    public void start(Stage primaryStage) throws Exception{
	window=primaryStage;    
    	Parent root = FXMLLoader.load(getClass().getResource("songLib_layout.fxml"));
	    FXMLLoader loader = new FXMLLoader();
	    Controller listController = loader.getController();
	    window.setTitle("Song Library");
	    window.setOnCloseRequest(e->{
	    		e.consume();
	    	//	listController.toFile();
	    		closeProgram();
	    });
	    window.setScene(new Scene(root, 650,650));
	    window.setResizable(false);
	    window.show();        
    
    }
    
    public void closeProgram() {
    		window.close();
    	
    }
    
    
   


}
