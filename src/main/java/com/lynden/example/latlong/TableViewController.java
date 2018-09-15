package com.lynden.example.latlong;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class TableViewController implements  Initializable {

	@FXML
	private TableView<User> tableId;
	
	@FXML
	private TableColumn<User, Text> textDelete;
	
	@FXML
	private TableColumn<User, Text> textName;
	
	@FXML
	private TableColumn<User, Text> textLock;
	
	@FXML
	private TableColumn<User, Text> textUnlock;
	
	@FXML
	private TableColumn<User, Button> button;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 
		
	}

}
