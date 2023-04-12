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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;


public class ResultsController implements Initializable {

    @FXML
    ListView<ResultSet> list = new ListView<ResultSet>();
    @FXML
    ObservableList<ResultSet> results = FXCollections.observableArrayList();
    
    public void setList(ObservableList<ResultSet> resultSetArray){
        for(ResultSet r : resultSetArray)
            {
                System.out.println(r.toString());
                list.getItems().addAll(r);
            }
        
    }
    
    
    /*@FXML
    public void setList(ResultSet rs) throws SQLException
    {
        int num=0;
        while(rs.next())
        {
            results.add(rs);
            
            
            int rsRoomNo = rs.getInt("room_No");
            int rsSize = rs.getInt("size");
            boolean rsSmoking = rs.getBoolean("smoking");
            boolean rsPet = rs.getBoolean("pet");
            double rsPrice = rs.getDouble("price");
                
            System.out.println("\n\nResult Set " + num);
            System.out.println("Room No: " + rsRoomNo);
            System.out.println("Size: " + rsSize);
            System.out.println("Smoking: " + rsSmoking);
            System.out.println("Pet: " + rsPet);
            System.out.println("Price: " + rsPrice);
            
            
        }
        list.setItems(results);
        System.out.println(list.toString()+"\n");
       
    }*/
    
    
    
    //private void 
    
    
    
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
        list.getItems().add(null);
        
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