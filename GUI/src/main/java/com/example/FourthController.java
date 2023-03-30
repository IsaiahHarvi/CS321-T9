package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class FourthController implements Initializable {

    @FXML   
    private ChoiceBox<String> rooms;
    private String roomsOptions[] = {"1","2","3"};



    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("third");
    }
    @FXML void switchToFifth() throws IOException{
        App.setRoot("fifth");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        rooms.getItems().addAll(roomsOptions);

    }
}