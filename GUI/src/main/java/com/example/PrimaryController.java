package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;


public class PrimaryController implements Initializable{
    


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadData();
        //test.getItems().addAll(testwords);

    }
    /*@FXML
    private ChoiceBox<String> test;
    private String testwords[] = {"1","2","3"};*/


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    private void loadData(){
        //test.getItems().addAll(testwords);
        //locationBox.getItems().addAll(Hotels);
    }
}
