package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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

    // Recieve resultSet object from App.java
    public void recieveResultSet(ResultSet rs) {
        System.out.println("Recieved ResultSet Object.");
        int limit = 0;

        /* Debug Option to Iterate through the ResultSet
            while (rs.next() and limit < 30) {
                int id = rs.getInt("room_No");
                int size = rs.getInt("hotel_No");
                System.out.print(id + " " + size + " ");
                limit++;
            }
        */

    }
}