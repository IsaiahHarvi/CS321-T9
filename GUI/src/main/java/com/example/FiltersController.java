package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;



public class FiltersController implements Initializable {

    @FXML
    private ChoiceBox<String> locationBox;
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
    private ChoiceBox<Integer> numBeds;
    private Integer[] beds = {1,2,3};
    
    @FXML
    private ChoiceBox<Integer> numBathrooms;
    private Integer[] bathrooms = {1,2,3};

    @FXML
    private boolean pets;

    @FXML
    private boolean smoking;


    
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML 
    private void switchToResults() throws IOException{
        App.setRoot("results");
    }
    @FXML   
    private void loadData(){
        locationBox.getItems().addAll(Hotels);
        //for some reason this doesn't work, it says it is empty when i try to run it
        //numBeds.getItems().addAll(beds);
        //numBathrooms.getItems().addAll(bathrooms);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadData();
        
    }
}