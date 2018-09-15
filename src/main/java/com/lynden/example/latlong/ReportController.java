package com.lynden.example.latlong;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReportController {

    //Load Choice Box Options
    ObservableList<String> reportHourList = FXCollections
            .observableArrayList("Hr","1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    ObservableList<String> reportMinuteList = FXCollections
            .observableArrayList("Min", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10"
                    ,"11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
                    ,"21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
                    ,"31", "32", "33", "34", "35", "36", "37", "38", "39", "40"
                    ,"41", "42", "43", "44", "45", "46", "47", "48", "49", "50"
                    ,"51", "52", "53", "54", "55", "56", "57", "58", "59");

    ObservableList<String> ampmList = FXCollections
            .observableArrayList("AM","PM");

    ObservableList<String> buroughList = FXCollections
            .observableArrayList("Burough","MANHATTAN", "STATEN ISLAND", "QUEENS"
                    , "BROOKLYN", "BRONX");
    
    ObservableList<String> locationTypeList = FXCollections
            .observableArrayList("Location Type","1-2 Family Dwelling"
                    , "3+ Family Apt. Building", "3+ Family Mixed Use Building"
                    , "Commercial Building", "Vacant Lot", "Construction Site"
                    , "Hospital", "Catch Basin/Sewer");
    
    private LatLong latLong = null;
    
    @FXML
    private DatePicker dateReport;
    
    @FXML
    private ChoiceBox<?> reportHour;
    
    @FXML
    private ChoiceBox<?> reportMinute;
    
    @FXML
    private ChoiceBox<?> ampm;
    
    @FXML
    private ChoiceBox<String> burough;
    
    @FXML
    private ChoiceBox<String> locationType;
    
    @FXML
    private TextField stAddress;

    @FXML
    private TextField zip_text; 
    
    @FXML
    private Label error;
    
    @FXML
    private TextField latitude;

    @FXML
    private TextField longitude;
    
    @FXML
    private void initialize() {
        burough.setValue("Burough");
        burough.setItems(buroughList);
        locationType.setValue("Location Type");
        locationType.setItems(locationTypeList);
        
    }
    
    @FXML
    public void geoCode() {
    	GeocodingService geocodingService = new GeocodingService();
        geocodingService.geocode(stAddress.getText().toString(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            latLong = null;
            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }
            
        });
    }

    // Check for Valid Input
    public void addSighting() {

        if(burough.getValue().equals(null)) {
        error.setText("Please enter a burough.");
        } else if(locationType.getValue().equals(null)) {
        error.setText("Please enter a Location Type.");
        } else if(stAddress.getText() == null || stAddress.getText().toString().equals("")) {
        	error.setText("Please enter an address.");
        } else if(zip_text.getText() == null || zip_text.getText().toString().equals("")) {
        	error.setText("Please enter a zip.");
        } else {
        	RatSighting s = new RatSighting("", "", locationType.getValue().toString(), zip_text.getText().toString(), stAddress.getText().toString(), "NEW YORK", burough.getValue().toString(), latitude.getText().toString(), longitude.getText().toString());
        	if(HTTPPostReq.addSighting(s)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Thank you for your report!");
                alert.show();
        		LatLongMainApp.goToHome();
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
}
