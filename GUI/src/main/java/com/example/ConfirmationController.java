package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class ConfirmationController implements Initializable {


    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML void switchToConfirmation() throws IOException{
        App.setRoot(null);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
}