/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.sql.*;


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
    public void recieveResultSet(ResultSet rs) throws SQLException {
        System.out.println("Recieved ResultSet Object.");
        int limit = 0;

         //Debug Option to Iterate through the ResultSet
            while (rs.next() && limit < 30) {
                int id = rs.getInt("room_No");
                int size=0;
                try {
                    size = rs.getInt("hotel_No");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.print(id + " " + size + " ");
                limit++;
            }
    }
}