package com.lynden.example.latlong;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class StatsController {

    //Load Choice Box Options
    ObservableList<String> statsList = FXCollections
            .observableArrayList("Number of Reports by Month","Number of Reports by Burough","Number of Reports by Location Type");
    
    @FXML
    private ChoiceBox statsBox;
    
    @FXML
    private Button submitStats; 
    
    @FXML
    private void initialize() {

          statsBox.setItems(statsList);
          statsBox.setValue("Number of Reports by Month");
    }

    
    public void openReport() {
        String statsBoxValue = (String) statsBox.getValue();
        System.out.println(statsBoxValue);
        if(statsBoxValue != null) {
            switch(statsBoxValue) {
            case "Number of Reports by Location Type": LatLongMainApp.goToStats3();  break;
            case "Number of Reports by Burough": LatLongMainApp.goToStats2();   break;
            case "Number of Reports by Month": LatLongMainApp.goToStats1();  break;
            default:
            	LatLongMainApp.goToStats3();  break;
            	
            }
        } 
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
}
