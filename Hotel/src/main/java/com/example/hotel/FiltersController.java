/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import java.sql.Date;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import com.example.hotel.RoomSearch;
import javafx.fxml.FXMLLoader;


public class FiltersController implements Initializable {

    @FXML
    private ChoiceBox<String> locationBox = new ChoiceBox<>();
    private String[] Hotels = {"Hotel England","Hotel Sweden","Hotel France","Hotel Italy","Hotel Japan","Hotel Switzerland","Hotel Alabama","Hotel Arizona","Hotel Arkansas",
                            "Hotel California","Hotel Colorado","Hotel Connecticut","Hotel Delaware","Hotel Florida","Hotel Georgia","Hotel Hawaii","Hotel Idaho","Hotel Illinois",
                        "Hotel Indiana","Hotel Iowa","Hotel Kansas","Hotel Kentucky","Hotel Louisiana","Hotel Maine","Hotel Maryland","Hotel Massachusetts","Hotel Michigan",
                    "Hotel Minnesota","Hotel Mississippi","Hotel Missouri","Hotel Montana","Hotel Nebraska","Hotel Nevada","Hotel New Hampshire","Hotel New Jersey",
                "Hotel New Mexico","Hotel New York","Hotel North Carolina","Hotel North Dakota","Hotel Ohio","Hotel Oklahoma","Hotel Oregon","Hotel Pennsylvania",
            "Hotel Rhode Island","Hotel South Carolina","Hotel South Dakota","Hotel Tennessee","Hotel Texas","Hotel Utah","Hotel Vermont","Hotel Virginia","Hotel Washington",
        "Hotel West Virginia","Hotel Wisconsin","Hotel Wyoming"};
    
    
    @FXML
    private Slider minPriceSlider;

    @FXML
    private Slider maxPriceSlider;

    @FXML
    private DatePicker checkInDate;

    @FXML
    private DatePicker checkOutDate;

    @FXML   
    private ChoiceBox<Integer> size = new ChoiceBox<>();
    private Integer[] sizeOptions = {2,4,5};


    @FXML
    private CheckBox pets;

    @FXML
    private CheckBox smoking;

    @FXML 
    private Button previous;

    @FXML 
    private Button next;


    
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML 
    private void switchToResults() throws IOException{
        App.setRoot("results");
        //System.out.println(search());
        
        App app = new App();
        //app.recieveRoomSearch(search());
        app.printRS(search());
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("results.fxml"));
        //ResultsController resultsController = loader.getController();
    }
 
    @FXML
    private RoomSearch search(){
        // Create filter object
        RoomSearch search = new RoomSearch();

        // Create application object to pass filter object to
        App application = new App();

        
        // Use function from app.java that returns a resultset
        search.setCity(locationBox.getValue());
        search.setMinPrice((int)minPriceSlider.getValue());
        search.setMaxPrice((int)maxPriceSlider.getValue());
        search.setCheckIn(Date.valueOf(checkInDate.getValue()));
        search.setCheckOut(Date.valueOf(checkOutDate.getValue()));
        search.setSize(size.getValue());
        search.setPets(pets.isSelected());
        search.setSmoking(smoking.isSelected());

        // Send filter object to App.java
        //application.recieveRoomSearch(search);
        
        application.getAvailableRooms(search);
        return search;
        
        // Use function from app.java that returns a resultset
        
        //return search.toString();
    }
  




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //loadData();
        locationBox.getItems().addAll(Hotels);
        size.getItems().addAll(sizeOptions);
    }

}