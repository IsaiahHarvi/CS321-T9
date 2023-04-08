package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class ResultsController implements Initializable {

    @FXML
    private void switchToFilters() throws IOException {
        App.setRoot("filters");
    }
    @FXML void switchToGuest() throws IOException{
        App.setRoot("guest");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
}