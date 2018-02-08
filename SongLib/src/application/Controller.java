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
	
	SongLibrary model = new SongLibrary();
	

	ObservableList<SongNode> stringList= FXCollections.observableArrayList();
	
	
	@FXML
	public void listInit() {
		//listView.getSelectionModel().selectedItemProperty().addListener(this);;
		
		
	
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


	public void initialize(SongLibrary model) {
		// TODO Auto-generated method stub
		/*stringList.add("123");
		stringList.add("123a");
		stringList.add("123b");
		listView.setItems(stringList);
	*/
		
		ObservableList<SongNode> myObservableList = FXCollections.observableList(model.songList);
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
		
	}


	

	
	
	
	
	
}