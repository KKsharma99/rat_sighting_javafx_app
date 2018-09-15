package com.lynden.example.latlong;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LatLongMainApp extends Application {
    
    public static Stage window;
    
    public static Scene home, report, filter, stats, adminSettings, settings, register
    , stats1, stats2, stats3, login, adminAdd;
    
    public static URL homeUrl, reportUrl, filterUrl, statsUrl, adminSettingsUrl
    ,settingsUrl, stats1Url, stats2Url, stats3Url, registerUrl, loginUrl, adminAddUrl;

    @Override
    public void start(Stage primaryStage) {
        
        // Load URLs. Used to build Scenes.
        adminSettingsUrl = getClass().getResource("/com/lynden/example/latlong/AdminSettings.fxml");
        settingsUrl = getClass().getResource("/com/lynden/example/latlong/Settings.fxml");
        reportUrl = getClass().getResource("/com/lynden/example/latlong/Report.fxml");
        filterUrl = getClass().getResource("/com/lynden/example/latlong/Filter.fxml");
        statsUrl = getClass().getResource("/com/lynden/example/latlong/Stats.fxml");
        homeUrl = getClass().getResource("/com/lynden/example/latlong/Scene.fxml");
        stats1Url = getClass().getResource("/com/lynden/example/latlong/Stats1.fxml");
        stats2Url = getClass().getResource("/com/lynden/example/latlong/Stats2.fxml");        
        stats3Url = getClass().getResource("/com/lynden/example/latlong/Stats3.fxml");
        loginUrl = getClass().getResource("/com/lynden/example/latlong/Login.fxml");
        registerUrl = getClass().getResource("/com/lynden/example/latlong/Register.fxml");
        adminAddUrl = getClass().getResource("/com/lynden/example/latlong/AdminAdd.fxml");
        
        window = primaryStage;
        window.setTitle("U Dirty Rat");
        new HTTPPostReq();

        try {
            window.getIcons().add(new Image("file:src/main/resources/img/rat.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        goToLogin();
    }

    public static Scene getScene() {
        return window.getScene();
    }
    
    public static void main(String[] args) {
        launch(args);
    }


    // Opens the Login Screen
    public static void goToLogin() {
        try {
        Parent loader = (Parent) FXMLLoader.load(loginUrl);
        login = new Scene(loader);
        window.setScene(login);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // LOGIN - Button Click Event Handling
    public void goToLogin(ActionEvent event) {
        goToLogin();
    }
    

    // Opens the Register Screen
    public static void goToRegister() {
        try {
        Parent loader = (Parent) FXMLLoader.load(registerUrl);
        register = new Scene(loader);
        window.setScene(register);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    // REGISTER - Button Click Event Handling
    public void goToRegister(ActionEvent event) {
        goToRegister();
    }


    // Opens the Home Screen
    public static void goToHome() {
        try {
        Parent loader = (Parent) FXMLLoader.load(homeUrl);
        home = new Scene(loader);
        window.setScene(home);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    // HOME - Button Click Event Handling
    public void goToHome(ActionEvent event) {
        goToHome();
    }

   
    
    // Opens the Report Screen
    public static void goToReport() {
        try {
        Parent loader = (Parent) FXMLLoader.load(reportUrl);
        report = new Scene(loader);
        window.setScene(report);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    // Report - Button Click Event Handling
    public void goToReport(ActionEvent event) {
        goToReport();
    }
    
    
    
    // Opens the Filter Screen
    public static void goToFilter() {
        try {
        Parent loader = (Parent) FXMLLoader.load(filterUrl);
        filter = new Scene(loader);
        window.setScene(filter);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    // FILTER - Button Click Event Handling
    public void goToFilter(ActionEvent event) {
        goToFilter();
    }
    
    // Opens the Stats Screen
    public static void goToStats() {
        try {
        Parent loader = (Parent) FXMLLoader.load(statsUrl);
        stats = new Scene(loader);
        window.setScene(stats);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    // STATS - Button Click Event Handling
    public void goToStats(ActionEvent event) {
        goToStats();
    }


    // Opens the Settings Screen
    public static void goToSettings() {
        try {
        Parent loader = (Parent) FXMLLoader.load(settingsUrl);
        settings = new Scene(loader);
        window.setScene(settings);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    // SETTINGS - Button Click Event Handling
    public void goToSettings(ActionEvent event) {
        goToSettings();
    }
    
    
    
    // Opens the Admin Settings Screen
    public static void goToAdminSettings() {
        try {

        Parent loader = (Parent) FXMLLoader.load(adminSettingsUrl);
        adminSettings = new Scene(loader);
        window.setScene(adminSettings);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
  
    // ADMIN SETTINGS - Button Click Event Handling
    public void goToAdminSettings(ActionEvent event) {
        goToAdminSettings();
    }
    
    // Opens the Admin Add User Screen
    public static void goToAdminAdd() {
        try {
        Parent loader = (Parent) FXMLLoader.load(adminAddUrl);
        adminAdd = new Scene(loader);
        window.setScene(adminAdd);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
  
    // ADMIN ADD USER - Button Click Event Handling
    public void goToAdminAdd(ActionEvent event) {
        goToAdminAdd();
    }

 // Opens the Stats2 Screen
    public static void goToStats1() {
        try {
        Parent loader = (Parent) FXMLLoader.load(stats1Url);
        stats1 = new Scene(loader);
        window.setScene(stats1);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
  
    // Stats2 - Button Click Event Handling
    public void goToStats1(ActionEvent event) {
        goToStats2();
    }
    
    // Opens the Stats2 Screen
    public static void goToStats2() {
        try {
        Parent loader = (Parent) FXMLLoader.load(stats2Url);
        stats2 = new Scene(loader);
        window.setScene(stats2);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
  
    // Stats2 - Button Click Event Handling
    public void goToStats2(ActionEvent event) {
        goToStats2();
    }
    
    
    // Opens the Stats3 Screen
    public static void goToStats3() {
        try {
        Parent loader = (Parent) FXMLLoader.load(stats3Url);
        stats3 = new Scene(loader);
        window.setScene(stats3);
        window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
  
    // Stats3 - Button Click Event Handling
    public void goToStats3(ActionEvent event) {
        goToStats3();
    }
}
