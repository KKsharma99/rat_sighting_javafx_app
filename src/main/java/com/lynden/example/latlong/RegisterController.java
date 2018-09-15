package com.lynden.example.latlong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {

	@FXML
	private TextField register_name;

	@FXML
	private TextField register_email;

	@FXML
	private TextField register_password;

	@FXML
	private Button register;

	@FXML
	private Button to_login;

	@FXML
	private TextField register_confirmpass;

	@FXML
	private Label register_error;

	public void goToLogin(ActionEvent event) {
		LatLongMainApp.goToLogin();
	}

	public void register(ActionEvent event) {
		String login_name = register_name.getText();
		String password = register_password.getText();
		String confirmpass = register_confirmpass.getText();
		String contact_info = register_email.getText();

		if (password.equals(confirmpass)) {
			if (password.length() > 5) {
				int result = HTTPPostReq.register(login_name, password, contact_info, false);
				switch (result) {
				case (0):
					LatLongMainApp.goToHome();
					break;
				case (1):
					register_error.setText("That username is taken");
					break;
				default:
					register_error.setText("Unknown");
					break;
				}
			} else {
				register_error.setText("Password must be more than 5 characters");
			}
		} else {
			register_error.setText("Passwords do not match");
		}
	}

}