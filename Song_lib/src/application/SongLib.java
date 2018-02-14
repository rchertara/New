package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
public class SongLib extends Application {
	
	Stage window;
	public static void main(String[] args) {
      	 launch(args);
    }
	
	/*@authors
	 * Rahil Chertara
	 * Avantika Yellapantula
	 * */

    @Override
    public void start(Stage primaryStage) throws Exception{
	window=primaryStage;    
    	Parent root = FXMLLoader.load(getClass().getResource("songLib_layout.fxml"));
	    FXMLLoader loader = new FXMLLoader();
	    Controller listController = loader.getController();
	    window.setTitle("Song Library");
	    window.setOnCloseRequest(e->{
	    		e.consume();
	    		if(listController.save_check==0) {
	    			//save button not clicked
	    			Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION);
	    			alert_confirm.setTitle("Confirmation of Close");
	    			alert_confirm.setHeaderText("Are you sure you want to close the program without saving?");
	    			Optional<ButtonType> result = alert_confirm.showAndWait();
	    			if (result.get() == ButtonType.OK){
	    			    // ... user chose OK
	    				closeProgram();
	    			 }
	    			
	    			else {
	    			    // ... user chose CANCEL or closed the dialog
	    				
	    			}
	    		}else {
	    			closeProgram();
	    		}
	    		
	    });
	    window.setScene(new Scene(root,950,800));
	    window.setResizable(false);
	    window.show();        
    
    }
    
    public void closeProgram() {
    		window.close();
    	
    }
    
    
   


}
