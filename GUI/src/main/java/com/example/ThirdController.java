package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ThirdController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML void switchToFourth() throws IOException{
        App.setRoot("fourth");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here for the slider */
    }
}