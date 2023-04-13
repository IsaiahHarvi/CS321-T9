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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import java.sql.Date;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import com.example.hotel.RoomSearch;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FiltersController implements Initializable {
    @FXML
    private ArrayList<String> results = new ArrayList<>();
    //private ObservableList<String> results = FXCollections.observableArrayList();
    
    private Stage stage;
    private Scene scene;
    
    private Parent root;
    private Parent homeRoot;
    public void setHomeRoot(Parent preRoot){this.homeRoot=preRoot;}

    @FXML
    private ChoiceBox<String> locationBox = new ChoiceBox<>();
    private String[] Hotels = {"Hotel England","Hotel Sweden","Hotel France","Hotel Italy","Hotel Japan","Hotel Switzerland","Hotel Alabama","Hotel Arizona","Hotel Arkansas",
                            "Hotel California","Hotel Colorado","Hotel Connecticut","Hotel Delaware","Hotel Florida","Hotel Georgia","Hotel Hawaii","Hotel Idaho","Hotel Illinois",
                        "Hotel Indiana","Hotel Iowa","Hotel Kansas","Hotel Kentucky","Hotel Louisiana","Hotel Maine","Hotel Maryland","Hotel Massachusetts","Hotel Michigan",
                    "Hotel Minnesota","Hotel Mississippi","Hotel Missouri","Hotel Montana","Hotel Nebraska","Hotel Nevada","Hotel New Hampshire","Hotel New Jersey",
                "Hotel New Mexico","Hotel New York","Hotel North Carolina","Hotel North Dakota","Hotel Ohio","Hotel Oklahoma","Hotel Oregon","Hotel Pennsylvania",
            "Hotel Rhode Island","Hotel South Carolina","Hotel South Dakota","Hotel Tennessee","Hotel Texas","Hotel Utah","Hotel Vermont","Hotel Virginia","Hotel Washington",
        "Hotel West Virginia","Hotel Wisconsin","Hotel Wyoming"};
    @FXML
    private Slider minPriceSlider;
    @FXML
    private Slider maxPriceSlider;
    @FXML
    private DatePicker checkInDate;
    @FXML
    private DatePicker checkOutDate;
    @FXML   
    private ChoiceBox<Integer> size = new ChoiceBox<>();
    private Integer[] sizeOptions = {2,4,5};
    @FXML
    private CheckBox pets;
    @FXML
    private CheckBox smoking;
    @FXML 
    private Button previous;
    @FXML 
    private Button next;
    
    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        homeRoot = loader.load();
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(homeRoot);
        stage.setScene(scene);
        stage.show();
    }
    @FXML 
    public void switchToResults(ActionEvent event) throws IOException{
        getAvailableRooms(search());
        System.out.println(results.toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("results.fxml"));
        root = loader.load();
        
        ResultsController resultController = loader.getController();
        resultController.displayListView(results);
        resultController.setHomeRoot(homeRoot);
        resultController.setFiltersRoot(this.root);
        
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private RoomSearch search()throws IOException{
        // Create filter object
        RoomSearch search = new RoomSearch();
        search.setCity(locationBox.getValue());
        search.setMinPrice((int)minPriceSlider.getValue());
        search.setMaxPrice((int)maxPriceSlider.getValue());
        search.setCheckIn(Date.valueOf(checkInDate.getValue()));
        search.setCheckOut(Date.valueOf(checkOutDate.getValue()));
        search.setSize(size.getValue());
        search.setPets(pets.isSelected());
        search.setSmoking(smoking.isSelected());
        return search;
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //loadData();
        locationBox.getItems().addAll(Hotels);
        size.getItems().addAll(sizeOptions);
    }

    
    
    // Connect to Hotel.db
    private Connection connection() {
        Connection connect = null;
        String url = ("jdbc:sqlite:" + new File("Database/Hotel.db").getAbsolutePath());
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
    
    public void getAvailableRooms(RoomSearch roomSearch)throws IOException {
        ResultSet rs = null;
        try (Connection conn = this.connection()) {
            PreparedStatement pstmnt = conn.prepareStatement(
                "SELECT r.room_No, r.size, r.smoking, r.pet, r.price FROM Room r\n" +
                "JOIN Hotel h ON r.hotel_No = h.hotel_No\n" +
                "WHERE h.name = ?\n" +
                "AND r.smoking = ?\n" +
                "AND r.pet = ?\n" +
                "AND r.size > ?\n" +
                "AND r.price >= ? AND r.price <= ?\n" +
                "AND NOT EXISTS (\n" +
                    "SELECT *\n" +
                    "FROM Booking b\n" +
                    "WHERE b.hotel_No = r.hotel_No AND b.room_No = r.room_No\n" +
                    "AND b.check_in_date <= ? AND b.check_out_date > ?\n" +
                ")");
            pstmnt.setString(1, roomSearch.getCity());
            pstmnt.setBoolean(2, roomSearch.isSmoking());
            pstmnt.setBoolean(3, roomSearch.isPets());
            pstmnt.setInt(4, roomSearch.getSize());
            pstmnt.setInt(5, roomSearch.getMinPrice());
            pstmnt.setInt(6, roomSearch.getMaxPrice());
            pstmnt.setDate(7, roomSearch.getCheckIn());
            pstmnt.setDate(8, roomSearch.getCheckOut());
            
            rs = pstmnt.executeQuery();
            //ObservableList<String> results = FXCollections.observableArrayList();
            while (rs.next()) {
                int rsRoomNo = rs.getInt("room_No");
                int rsSize = rs.getInt("size");
                boolean rsSmoking = rs.getBoolean("smoking");
                boolean rsPet = rs.getBoolean("pet");
                double rsPrice = rs.getDouble("price");
                
                String x = "Room Number:"+rsRoomNo+"\nRoomSize: "+rsSize+" Smoking :"+rsSmoking+" Pets :"+rsPet+"\nPrice: "+rsPrice;
                //ADD THESE VARIABLES TO OBSERVABLESTRING ARRAY
                results.add(x);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}