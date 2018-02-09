package application;


import javafx.scene.control.ListCell;


import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Optional;
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
			 library.Add(new SongNode("Rahil","Hate"));
			// library.Add(new SongNode("Rahil","Hate"));
		       
		        
			 
			 
			 
		 // library.print();	 
		  listView.setItems(library.getsongList());
		  listView.getSelectionModel();
		  
		 if (library.getsongList().size() > 0) {
	       listView.getSelectionModel().select(0);
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
			
			//
	
	}
	

	public void addClicked() {
	
		if(nameField.getText().equals("")) {
			Alert alert_name = new Alert(Alert.AlertType.WARNING, "Song name is empty.", ButtonType.OK);
			alert_name.showAndWait();
		}
		else if(artistField.getText().equals("")) {
			Alert alert_artist = new Alert(Alert.AlertType.WARNING, "Artist name is empty.", ButtonType.OK);
			alert_artist.showAndWait();
		}
		else {
			Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION);
			alert_confirm.setTitle("Confirmation of Addition");
			alert_confirm.setHeaderText("Confirm the following:");
			Optional<ButtonType> result = alert_confirm.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK
				SongNode newNode= new SongNode(nameField.getText(),artistField.getText(), albumField.getText(),yearField.getText());
		        library.Add(newNode); //has sort in it 
		        listView.setItems(library.getsongList());//great this works!!!
			} else {
			    // ... user chose CANCEL or closed the dialog
				
				}
     
	     }
	
	}
	
	public void editClicked() {

		if(nameFieldedit.getText().equals("")) {
			Alert alert_name = new Alert(Alert.AlertType.WARNING, "Song name is empty.", ButtonType.OK);
			alert_name.showAndWait();
		}
		else if(artistFieldedit.getText().equals("")) {
			Alert alert_artist = new Alert(Alert.AlertType.WARNING, "Artist name is empty.", ButtonType.OK);
			alert_artist.showAndWait();
		}
		else {
			Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to make these changes?");
			alert_confirm.setTitle("Confirmation of Edit");
			alert_confirm.setHeaderText("Confirm the following:");
			Optional<ButtonType> result = alert_confirm.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK
				SongNode song = listView.getSelectionModel().getSelectedItem();	
				library.Edit(song.SongName, song.ArtistName, nameFieldedit.getText(), artistFieldedit.getText(), albumFieldedit.getText(), yearFieldedit.getText());
				listView.setItems(library.getsongList());
			} else {
			    // ... user chose CANCEL or closed the dialog
				
			}
	        
		}
	}
	
	public void delClicked() {
		Alert alert_confirm = new Alert(Alert.AlertType.CONFIRMATION);
		alert_confirm.setTitle("Confirmation of Deletion");
		alert_confirm.setHeaderText("Confirm the following:");
		Optional<ButtonType> result = alert_confirm.showAndWait();
		if (result.get() == ButtonType.OK){
		    // ... user chose OK
			SongNode song = listView.getSelectionModel().getSelectedItem();	
			library.Delete(song.SongName, song.ArtistName);
			listView.setItems(library.getsongList());
		} else {
		    // ... user chose CANCEL or closed the dialog
			
		}
		
        //alert_confirm.showAndWait();
	}


}


	

	
	
	
	
	
