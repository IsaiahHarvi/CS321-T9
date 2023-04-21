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
import javafx.stage.Stage;

/**
 * Home scene controller, this is the starting scene
 * @author caseybramlett
 */

public class HomeController implements Initializable{
    

    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loadData();

    }

    @FXML
    /**
     * switches to filters scene
     */
    private void switchToFilters(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("filters.fxml"));
        root = loader.load();
        
        FiltersController filtersController = loader.getController();
        filtersController.setHomeRoot(this.root);
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    /**
     * switches to checkout scene
     */
    private void switchToCheckOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("checkout.fxml"));
        root = loader.load();
        
        CheckOutController checkout = loader.getController();
        checkout.setHomeRoot(this.root);
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * does nothing yet
     */
    private void loadData(){
    }
}
