package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class FifthController implements Initializable {

    @FXML
    private void switchToFourth() throws IOException {
        App.setRoot("fourth");
    }
    @FXML void switchToSixth() throws IOException{
        App.setRoot("sixth");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
}