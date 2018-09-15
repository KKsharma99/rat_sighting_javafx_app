package com.lynden.example.latlong;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.event.GMapMouseEvent;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import com.lynden.example.latlong.LatLongMainApp;

public class LatLongFXMLController implements Initializable {


    public static int markerCount = 0;

    //LatLong Location Objects
    public static ArrayList<LatLong> latLongList = new ArrayList<LatLong>();

    //MarkerOptions Objects (Needed to make Markers)
    public static ArrayList<MarkerOptions> markerOptionsList = 
            new ArrayList<MarkerOptions>();
 
    //Marker Objects
    public static ArrayList<Marker> markerList = new ArrayList<Marker>();

    //Info Window Options List
    public static ArrayList<InfoWindowOptions> infoWindowOptionsList = 
            new ArrayList<InfoWindowOptions>();

    //Info Window List
    public static ArrayList<InfoWindow> infoWindowList = 
            new ArrayList<InfoWindow>();

    @FXML
    private GoogleMapView googleMapView;

    private GoogleMap map;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        googleMapView.addMapInitializedListener(() -> configureMap());
    }

    protected void configureMap() {
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(40.79411373034442, -73.97456746164642))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(10);
        map = googleMapView.createMap(mapOptions, false);
        
        ArrayList<RatSighting> sightings = HTTPPostReq.getSightings(50, 0);
        
        if(FilterController.borough != null) {
        	sightings = HTTPPostReq.sort("borough", FilterController.borough, 50, 0);
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Filtered to borough: " + FilterController.borough);
            alert.show();
        } else if(FilterController.zip != null) {
        	sightings = HTTPPostReq.sort("zip", FilterController.zip, 50, 0);
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Filtered to zip: " + FilterController.zip);
            alert.show();
        } else if(FilterController.loc_type != null) {
        	sightings = HTTPPostReq.sort("loc_type", FilterController.loc_type, 50, 0);
        	Alert alert = new Alert(Alert.AlertType.INFORMATION, "Filtered to location type: " + FilterController.loc_type);
            alert.show();
        }
        
        for(RatSighting s : sightings) {
        	addMarker(s.getLatitude(), s.getLongitude(), s.getDate(), null, s.getAddress(), s.getZip(), s.getBorough(), s.getLoc_type());
        }
        
        //addMarker("47.6197", "-122.3231", "11/04/12", "05:34 PM",
        //     "4326 Coventry Court", "94587", "Manhattan", "Hospital");
     
    }
    
    // Creates Marker, InfoWindow, and UIEventHandler
    public void addMarker(String aLatitude, String aLongitude, String date,
            String time, String address, String zip, String borough, 
            String type) {
        
        if(date == null) {
            date = "NA"; 
        }

        if(time == null) {
            time = "NA"; 
        }

        if(address == null) {
            address = "NA"; 
        }
        
        if(zip == null) {
            zip = "NA"; 
        }

        if(borough == null) {
            borough = "NA"; 
        }

        if(type == null) {
            type = "NA"; 
        }
        
        if(aLatitude == null || aLongitude == null) {
            System.out.println("Latitude/Longitude cannot be null");
            return;
        }
        
        //Cast Lat/Long to Float
        float latitude = Float.parseFloat(aLatitude);
        float longitude = Float.parseFloat(aLongitude);
        
        
        // Creates a location object
        latLongList.add(new LatLong(latitude, longitude));

        // Creates a new Marker Options Object (Needed to Make Marker)
        markerOptionsList.add(new MarkerOptions());
        
        // Sets Current Marker Options Object to Marker's Location
        markerOptionsList.get(markerCount).position(latLongList.get(markerCount));

        // Creates a New Marker
        markerList.add(new Marker(markerOptionsList.get(markerCount)));
        
        // Adds Marker to Map
        map.addMarker(markerList.get(markerCount));
        
        // InfoWindowOption Creation
        infoWindowOptionsList.add(new InfoWindowOptions());
        
        // Add Content to InfoWindowOptions
        infoWindowOptionsList.get(markerCount).content("<h3>Sighting Details</h3>"
                + "Date Reported: " + date + "<br>"
                + "Time Reported: " + time + "<br>"
                + "Address: " + address + ", " + zip + "<br>"
                + "Borough: " + borough + "<br>"
                + "Type: " + type);
        
        // Create InfoWindow Object
        infoWindowList.add(new InfoWindow(infoWindowOptionsList
                .get(markerCount)));
 
        int id = markerCount;
        
        // When Marker is Clicked the InfoWindow Will Display                
        map.addUIEventHandler(markerList.get(id), UIEventType.click, (JSObject obj) -> {
            infoWindowList.get(id).open(map, markerList.get(id));
        });
        
        markerCount++;
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