package com.lynden.example.latlong;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class FilterController {
	
	public static String borough;
	public static String zip;
	public static String loc_type;

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
            .observableArrayList("MANHATTAN", "STATEN ISLAND", "QUEENS"
                    , "BROOKLYN", "BRONX");
    
    ObservableList<String> locationTypeList = FXCollections
            .observableArrayList("1-2 Family Dwelling"
                    , "3+ Family Apt. Building", "3+ Family Mixed Use Building"
                    , "Commercial Building", "Vacant Lot", "Construction Site"
                    , "Hospital", "Catch Basin/Sewer");
    
    @FXML
    private ChoiceBox reportHourFrom;
    
    @FXML
    private ChoiceBox reportMinFrom;
    
    @FXML
    private ChoiceBox ampmFrom;
    
    @FXML
    private ChoiceBox reportHourTo;
    
    @FXML
    private ChoiceBox reportMinTo;
    
    @FXML
    private ChoiceBox ampmTo;
    
    @FXML
    private ChoiceBox buroughFilter;
    
    @FXML
    private ChoiceBox locationTypeFilter;
    
    @FXML
    private Button submit_filter;
    
    @FXML
    private TextField zip_text;
    
    @FXML
    private void initialize() {
        reportHourFrom.setValue("Hr");
        reportHourFrom.setItems(reportHourList);
        reportHourTo.setValue("Hr");
        reportHourTo.setItems(reportHourList);
        reportMinFrom.setValue("Min");
        reportMinFrom.setItems(reportMinuteList);
        reportMinTo.setValue("Min");
        reportMinTo.setItems(reportMinuteList);
        ampmFrom.setValue("AM");
        ampmFrom.setItems(ampmList);
        ampmTo.setValue("AM");
        ampmTo.setItems(ampmList);
        buroughFilter.setItems(buroughList);
        locationTypeFilter.setItems(locationTypeList);
        FilterController.borough = null;
        FilterController.zip = null;
        FilterController.loc_type = null;
        
    }
    
    public void setFilter(ActionEvent event) {
    	if(buroughFilter.getValue() != null && !buroughFilter.getValue().toString().equals("")) {
    		System.out.println("borough");
    		FilterController.borough = buroughFilter.getValue().toString();
    	} else if(locationTypeFilter.getValue() != null && !locationTypeFilter.getValue().toString().equals("")) {
    		FilterController.loc_type = locationTypeFilter.getValue().toString();
    	} else if(zip_text.getText() != null && !zip_text.getText().equals("")) {
    		FilterController.zip = zip_text.getText();
    	}
    	
    	LatLongMainApp.goToHome();
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
