package com.lynden.example.latlong;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;



public class Stat2Controller implements Initializable {
    

    @FXML
    private BarChart<?, ?> boroughChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    
    public XYChart.Series series; 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 series = new XYChart.Series();
    	 HashMap<String, Integer> bcount = HTTPPostReq.countBorough();
    	 Set<String> keyset = bcount.keySet();
    	 System.out.println(keyset.size());
    	 ArrayList<String> keys = new ArrayList<String>();
    	 for(String string : keyset) {
    		 keys.add(string);
    	 }
    	 
    	 Collection<Integer> valueset = bcount.values();
    	 System.out.println(valueset.size());
    	 ArrayList<Integer> values = new ArrayList<Integer>();
    	 for(Integer value : valueset) {
    		 values.add(value);
    	 }
    	 
    	 addPoints(values, keys);
         boroughChart.getData().addAll(series);
        
    }
    
	public void addPoints(ArrayList<Integer> second, ArrayList<String> first) {
		for (int i = 0; i < first.size(); i++) {
			series.getData().add(new XYChart.Data(first.get(i), second.get(i)));
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
