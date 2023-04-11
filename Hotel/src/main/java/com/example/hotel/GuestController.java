/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;



public class GuestController implements Initializable {

    //first name
    @FXML
    private TextField firstname = new TextField();
    
    //last name
    @FXML
    private TextField lastname = new TextField();
    
    //email
    @FXML
    private TextField email = new TextField();
    
    //phone number
    @FXML
    private TextField phonenumber = new TextField();
    
    @FXML
    private void AddGuestToDataBase(){
        App app = new App();
        app.insert(firstname.getText(), lastname.getText(), email.getText(), phonenumber.getText());
        
    }
    
    
    
    @FXML
    private void switchToResults() throws IOException {
        App.setRoot("results");
    }
    @FXML void switchToConfirmation() throws IOException{
        AddGuestToDataBase();
        App.setRoot("confirmation");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
} 
