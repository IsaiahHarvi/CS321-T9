/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import java.io.IOException;
import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Controller class for results scene where available rooms are displayed on list
 * @author caseybramlett
 */
public class ResultsController {
    @FXML
    ListView<String> list = new ListView<>();
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    /**
     * function to receive hotel number from filters, will then be sent to guestController
     */
    public int hotelNum;
    public void setHotelNum(int n){hotelNum = n;}
    
    /**
     * receives home root
     */
    private Parent homeRoot;
    public void setHomeRoot(Parent preRoot){this.homeRoot=preRoot;}
    
    /**
     * receives filters root
     */
    private Parent filtersRoot;
    public void setFiltersRoot(Parent filtersRoot){this.filtersRoot=filtersRoot;}
    
    /**
     * takes in arrayList that contains all room options
     * and puts them in the list
     * @param s - arrayList of options
     */
    public void displayListView(ArrayList<String> s){
        list.getItems().addAll(s);
    }
    public void refreshList(){list.refresh();} 
    
    /**
     * switches to back to filters scene
     * @param event
     * @throws IOException 
     */
    @FXML
    private void switchToFilters(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("filters.fxml"));
        filtersRoot = loader.load();
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(filtersRoot);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * switches to guest scene
     * @param event
     * @throws IOException 
     */
    @FXML
    public void switchToGuest(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("guest.fxml"));
        root = loader.load();
        
        GuestController guestController = loader.getController();
        //guestController.AddGuestToDataBase();
        guestController.setHomeRoot(homeRoot);
        guestController.setResultRoot(this.root);
        guestController.setSelected(list.getSelectionModel().getSelectedItem());
        
        guestController.recieveDatesAndHotel(checkIn, checkOut,hotelNum);
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    public String checkIn,checkOut;
    /**
     * receives dates from filtersController
     * @param in
     * @param out 
     */
    public void recieveDates(String in,String out){
        checkIn=in;checkOut=out;
    }
}