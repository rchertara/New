package application;


import javafx.scene.control.ListCell;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class Controller{
	
	//Buttons
	@FXML Button addButton;
	@FXML Button editButton;
	@FXML Button delButton;
	//TextField
	@FXML TextField nameField;
	@FXML TextField artistField;
	@FXML TextField albumField;
	@FXML TextField yearField;
	//ListView
	@FXML public ListView<SongNode> listView;
	
	SongLibrary library = new SongLibrary();

	
	ObservableList<String> stringList= FXCollections.observableArrayList();
	
	
	
	
	 @FXML
	    public void initialize() {
		 library.parse();
		 library.sortAscending();
		 //library.print();
	       // SongLibraryModel.setTheModel(library);
	        //
	        listView.setItems(library.getsongList());
	       
	    }

	
	
	public void addClicked() {
		//nameField empty
		if(nameField.getText().equals("")) {
			Alert alert_name = new Alert(Alert.AlertType.WARNING, "Song name is empty.", ButtonType.OK);
			alert_name.showAndWait();
		}
		else if(artistField.getText().equals("")) {
			Alert alert_artist = new Alert(Alert.AlertType.WARNING, "Artist name is empty.", ButtonType.OK);
			alert_artist.showAndWait();
		}
		else {
			Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to add this song to the list?", ButtonType.YES,  ButtonType.CANCEL);
	        alert_confirm.showAndWait();
		}
		
	}
	
	public void editClicked() {
		if(nameField.getText().equals("")) {
			Alert alert_name = new Alert(Alert.AlertType.WARNING, "Song name is empty.", ButtonType.OK);
			alert_name.showAndWait();
		}
		else if(artistField.getText().equals("")) {
			Alert alert_artist = new Alert(Alert.AlertType.WARNING, "Artist name is empty.", ButtonType.OK);
			alert_artist.showAndWait();
		}
		else {
			Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to make these changes?", ButtonType.YES,  ButtonType.CANCEL);
	        alert_confirm.showAndWait();
		}
	}
	
	public void delClicked() {
		Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to make these changes?", ButtonType.YES,  ButtonType.CANCEL);
        alert_confirm.showAndWait();
	}


	
//	public void initialize() {
//		// TODO Auto-generated method stub
//		
//		for (int i = 0; i < model.songList.size(); i++) {
//			
//		}
//		
//		
//		stringList.add("");
//		listView.setItems(stringList);
//		
//	}


	
	
}


	

	
	
	
	
	
