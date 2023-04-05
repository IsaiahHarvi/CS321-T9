package com.example;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class GuestController implements Initializable {

    @FXML
    private void switchToResults() throws IOException {
        App.setRoot("results");
    }
    @FXML void switchToConfirmation() throws IOException{
        App.setRoot("confirmation");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
} 
