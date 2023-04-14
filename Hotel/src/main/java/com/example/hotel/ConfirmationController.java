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
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ConfirmationController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent homeRoot;
    public void setHomeRoot(Parent preRoot){this.homeRoot=preRoot;}
    @FXML
    Label myLabel;

    @FXML
    public void setLabel(String s){myLabel.setText(s);} 
    @FXML
    public void switchToHome(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        homeRoot = loader.load();
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
}