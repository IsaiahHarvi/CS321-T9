package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class SecondaryController implements Initializable {

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
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        locationBox.getItems().addAll(Hotels);
    }
}