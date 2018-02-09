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
	//TextField	1-4
	@FXML TextField nameField;
	@FXML TextField artistField;
	@FXML TextField albumField;
	@FXML TextField yearField;
	//TextField 5-8
	@FXML TextField nameFieldedit;
	@FXML TextField artistFieldedit;
	@FXML TextField albumFieldedit;
	@FXML TextField yearFieldedit;
	//ListView
	@FXML public ListView<SongNode> listView;
	
	SongLibrary library = new SongLibrary();

	
	ObservableList<String> stringList= FXCollections.observableArrayList();
	
	
	
	
	 //@SuppressWarnings("unchecked")
	@FXML
	    public void initialize() {  
		 library.parse();
		 library.sortAscending();
		   //library.print();
	       // SongLibraryModel.setTheModel(library);
	        //
	  listView.setItems(library.getsongList());
	  listView.getSelectionModel();
	  
	 if (library.getsongList().size() > 0) {
      //    listView.getSelectionModel().select(3);
      }
     
     // int index = listView.getSelectionModel().getSelectedIndex();
	  //listView.getSelectionModel().select(index);
	    
	//setting edit stuff to non-visible
		nameFieldedit.setDisable(true);
		artistFieldedit.setDisable(true);
		albumFieldedit.setDisable(true);
		yearFieldedit.setDisable(true);
	}//initialize method

	
	public void listSelect() {
	listView.getSelectionModel().getSelectedItem();	
	
	//when something is selected, do the following:
	//setting edit stuff to non-visible
			nameFieldedit.setDisable(false);
			artistFieldedit.setDisable(false);
			albumFieldedit.setDisable(false);
			yearFieldedit.setDisable(false);
	
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
	        
	        SongNode newNode= new SongNode(nameField.getText(),artistField.getText());
	        library.Add(newNode); //has sort in it 
	        listView.setItems(library.getsongList());//great this works!!!
	        
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


	

	
	
	
	
	
