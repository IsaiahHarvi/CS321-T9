/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.hotel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class CheckOutController implements Initializable{
    
    
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent homeRoot;
    public void setHomeRoot(Parent preRoot){this.homeRoot=preRoot;}
    
    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        homeRoot = loader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
    
    // Connect to Hotel.db
    private Connection connection() {
        Connection connect = null;
        String url = ("jdbc:sqlite:" + new File("src//main///java///Database//Hotel.db").getAbsolutePath());
        System.out.println(url);
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection(url);
            // System.out.println("Connection to SQLite has been established.");
        } catch (ClassNotFoundException ex) {
            System.out.println("connect: " + connect); // add this lin
            System.out.println("Connection to DB failed! DB not found! \n" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Connection to DB failed! SQL exception thrown! \n" + ex.getMessage());
        }

        return connect;
    }
    
    @FXML
    private TextField number = new TextField();
    
    
    
    @FXML
    private Button delete;
    public void deleteRes(String phone){
        //String RMquery = ("DELTE FROM Booking WHERE guest_No = ?) VALUES (",phone);
        String sql = "DELETE FROM Booking WHERE guest_No = ?";
        
        try (Connection conn = this.connection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // System.out.println("conn: " + conn); // add this line

            pstmt.setLong(1, Long.parseLong(phone));
            pstmt.executeUpdate();
            System.out.println("Reservation has been removed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML 
    public void removeRes(){
        String phone = number.getText();
        deleteRes(phone);
        number.setText("Reservation Deleted");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       
        //test.getItems().addAll(testwords);

    }
    
    
    
    
}

