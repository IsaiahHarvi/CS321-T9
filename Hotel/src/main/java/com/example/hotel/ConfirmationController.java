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

/**
 * controller for last scene in check in process
 * @author caseybramlett
 */
public class ConfirmationController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent homeRoot;
    /**
     * sets home room that has been passed from previous scenes
     * @param preRoot 
     */
    public void setHomeRoot(Parent preRoot){this.homeRoot=preRoot;}
    @FXML
    Label myLabel;

    /**
     * sets label with guest information for confirmation
     * @param s 
     */
    @FXML
    public void setLabel(String s){myLabel.setText(s);} 
    
    
    public static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * switches to previous home scene
     * @param event
     * @throws IOException 
     */
    @FXML
    public void switchToHome(ActionEvent event) throws IOException{
        scene = new Scene(loadFXML("home"), 1000, 1000);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        /*something goes here */
    }
}