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
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ResultsController {
    @FXML
    ListView<String> list = new ListView<>();
    ArrayList<String> tempList = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Parent homeRoot;
    public void setHomeRoot(Parent preRoot){this.homeRoot=preRoot;}
    
    private Parent filtersRoot;
    public void setFiltersRoot(Parent filtersRoot){this.filtersRoot=filtersRoot;}
    
    //ObservableList<String> s
    public void displayListView(ArrayList<String> s){
        list.getItems().addAll(s);
        tempList=s;
    }
    public void refreshList(){list.refresh();} 
    
    @FXML
    private void switchToFilters(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("filters.fxml"));
        filtersRoot = loader.load();
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(filtersRoot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToGuest(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("guest.fxml"));
        root = loader.load();
        
        GuestController guestController = loader.getController();
        //guestController.AddGuestToDataBase();
        guestController.setHomeRoot(homeRoot);
        guestController.setResultRoot(this.root);
        guestController.setList(tempList);
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}