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



public class HomeController implements Initializable{
    


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadData();
        //test.getItems().addAll(testwords);

    }
    /*@FXML
    private ChoiceBox<String> test;
    private String testwords[] = {"1","2","3"};*/


    @FXML
    private void switchToFilters() throws IOException {
        App.setRoot("filters");
    }

    //does nothin yet
    private void loadData(){
        //test.getItems().addAll(testwords);
        //locationBox.getItems().addAll(Hotels);
    }
}
