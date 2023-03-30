package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class SixthController implements Initializable {


    @FXML
    private void switchToFifth() throws IOException {
        App.setRoot("fifth");
    }
    @FXML void switchToNull() throws IOException{
        App.setRoot(null);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
}