package com.lynden.example.latlong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField login_text;

	@FXML
	private TextField login_password;

	@FXML
	private Button login_button;

	@FXML
	private Button register_button;
	
	@FXML
    private Label errormsg;

	// HOME - Button Click Event Handling
	public void login(ActionEvent event) {
		int result = HTTPPostReq.login(login_text.getText(), login_password.getText());
		switch (result) {
		case (0):
			LatLongMainApp.goToHome();
			break;
		case (1):
			errormsg.setText("Incorrect password");
			break;
		case (2):
			errormsg.setText("User does not exist");
			break;
		case (3):
			errormsg.setText("Account is locked");
			break;
		default:
			errormsg.setText("Unknown");
			break;
		}

	}

	// REGISTER - Button Click Event Handling
	public void goToRegister(ActionEvent event) {
		LatLongMainApp.goToRegister();
	}
}