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
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class ResultsController implements Initializable {

    //private ObservableList<ResultSet> data; //= FXCollections.observableArrayList();;
    
    //private List<ResultSet> resultList = new ArrayList<ResultSet>();
    private ObservableList<ResultSet> results = FXCollections.observableArrayList();
    private ObservableList<String> resultString = FXCollections.observableArrayList();
    
    @FXML 
    private ListView<String> list = new ListView<>();
    
    public void addString(String s){
    
        resultString.add(s);
        //System.out.println(s);
        //System.out.println(resultString.toString()+"\n\n");
        //list.setItems(resultString);
        list.getItems().addAll(resultString);
        refreshList();
        //list.refresh();
        
    }
    public void refreshList(){list.refresh();}
    
    public void printResults(){
        for(String s: resultString){
            System.out.println(resultString);
        }
        refreshList();
    }
    
    
    /*public void addIntToList(int i){    list.getItems().addAll(i);        }
   
    public void refreshList() throws SQLException{
        System.out.println(list.getItems().toString());
        for(ResultSet r:results){
            Integer roomNumber = r.getInt("room_No");
            list.getItems().addAll(roomNumber);
        }
    }
    
    public void addDataToListView(){
        //list.getItems().addAll(results.toString());
        System.out.println("RESULTS HAVE BEEN ADDED");
    }
    
    public void setResultsData (ResultSet rs) {   
            results.add(rs);
    }
    
    public void printResults(){
        System.out.println(results.toString());
    }*/
   
    

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