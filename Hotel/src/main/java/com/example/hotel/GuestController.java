/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class GuestController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    public void AddGuestToDataBase(){
        App app = new App();
        app.insert(firstname.getText(), lastname.getText(), email.getText(), phonenumber.getText());
        System.out.println("Adding guest to Data Base function has completed ");
    }
    
    
    
    @FXML
    private void switchToResults() throws IOException {
        App.setRoot("results");
    }
    public void switchToConfirmation(ActionEvent event) throws IOException{
        String s = firstname.getText()+" "+lastname.getText()+"\n "+email.getText()+"\n "+phonenumber.getText();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
        root = loader.load();
        ConfirmationController confirmationController = loader.getController();
        
        confirmationController.setLabel("Your Information: "+s);
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
} 
