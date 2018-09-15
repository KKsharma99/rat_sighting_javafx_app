package com.lynden.example.latlong;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class AdminSettingsController implements Initializable {

	@FXML
	private TableView table;

	@FXML
	private TableColumn delete;

	@FXML
	private TableColumn name;

	@FXML
	private TableColumn lock;

	ObservableList<User> data;

	public void initialize(URL url, ResourceBundle rb) {
		data = FXCollections.observableArrayList(HTTPPostReq.getUsers());
		delete.setCellValueFactory(new PropertyValueFactory<User, String>("_delete"));
		delete.setCellFactory(new Callback<TableColumn<User, String>, TableCell<User, String>>() {
			@Override
			public TableCell<User, String> call(TableColumn<User, String> col) {
				final TableCell<User, String> cell = new TableCell<>();
				cell.textProperty().bind(cell.itemProperty()); // in general
																// might need to
																// subclass
																// TableCell and
																// override
																// updateItem(...)
																// here
				cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							// handle right click on cell...
							// access cell data with cell.getItem();
							// access row data with
							// (Person)cell.getTableRow().getItem();
							User user = (User) cell.getTableRow().getItem();
							user.set_isLocked(true);
							Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete user " + user.get_name() + "?");
							Optional<ButtonType> result = alert.showAndWait();
							if(result.get() == ButtonType.OK) {
								HTTPPostReq.deleteUser(user.get_id());
								Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "Deleted user " + user.get_name());
								alert2.showAndWait();
								LatLongMainApp.goToAdminSettings();
							}

						}
					}
				});
				return cell;
			}
		});
		
		name.setCellValueFactory(new PropertyValueFactory<User, String>("_name"));
		lock.setCellValueFactory(new PropertyValueFactory<User, String>("_lockStatus"));
		lock.setCellFactory(new Callback<TableColumn<User, String>, TableCell<User, String>>() {
			@Override
			public TableCell<User, String> call(TableColumn<User, String> col) {
				final TableCell<User, String> cell = new TableCell<>();
				cell.textProperty().bind(cell.itemProperty()); // in general
																// might need to
																// subclass
																// TableCell and
																// override
																// updateItem(...)
																// here
				cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							// handle right click on cell...
							// access cell data with cell.getItem();
							// access row data with
							// (Person)cell.getTableRow().getItem();
							if (cell.getItem().equalsIgnoreCase("lock")) {
								User user = (User) cell.getTableRow().getItem();
								user.set_isLocked(true);
								Alert alert = new Alert(Alert.AlertType.INFORMATION, "Locked user " + user.get_name());
								alert.showAndWait();
								LatLongMainApp.goToAdminSettings();
							} else {
								User user = (User) cell.getTableRow().getItem();
								user.set_isLocked(false);
								Alert alert = new Alert(Alert.AlertType.INFORMATION,
										"Unlocked user " + user.get_name());
								alert.showAndWait();
								LatLongMainApp.goToAdminSettings();
							}
						}
					}
				});
				return cell;
			}
		});

		table.setItems(data);
	}

	public void lock() {
		System.out.println("test");
	}

	// ADMIN SETTINGS - Button Click Event Handling
	public void goToAdminSettings(ActionEvent event) {
		LatLongMainApp.goToAdminSettings();
	}

	// SETTINGS - Button Click Event Handling
	public void goToSettings(ActionEvent event) {
		LatLongMainApp.goToSettings();
	}

	// Report - Button Click Event Handling
	public void goToReport(ActionEvent event) {
		LatLongMainApp.goToReport();
	}

	// FILTER - Button Click Event Handling
	public void goToFilter(ActionEvent event) {
		LatLongMainApp.goToFilter();
	}

	// STATS - Button Click Event Handling
	public void goToStats(ActionEvent event) {
		LatLongMainApp.goToStats();
	}

	// HOME - Button Click Event Handling
	public void goToHome(ActionEvent event) {
		LatLongMainApp.goToHome();
	}

	// STATS2 - Button Click Event Handling
	public void goToStats2(ActionEvent event) {
		LatLongMainApp.goToStats2();
	}

	// STATS3 - Button Click Event Handling
	public void goToStats3(ActionEvent event) {
		LatLongMainApp.goToStats3();
	}

	// ADMIN ADD USER - Button Click Event Handling
	public void goToAdminAdd(ActionEvent event) {
		LatLongMainApp.goToAdminAdd();
	}

}
