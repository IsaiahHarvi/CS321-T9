package com.example.hotel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.File;

import java.sql.Statement; //I think this will fix the issue but im not sure - Casey 

//import 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;


    // Recieve RoomSearch object from FiltersController.java
    public void recieveRoomSearch(RoomSearch roomSearch) {
        System.out.println("Recieved RoomSearch Object.");
        FiltersController fiter = new FiltersController();
        
    }
    
    //test to see if it sees roomsearch object
    public void printRS(RoomSearch rs){
        System.out.println(rs.toString());
    }

    
    // Connect to Hotel.db
    private Connection connection() {
        Connection connect = null;
        String url = ("jdbc:sqlite:" + new File("Database\\Hotel.db").getAbsolutePath());
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


    // Insert a guest into the Guest table
    public void insert(String fName, String lName, String email, String phoneNum) {
        String sql = "INSERT INTO Guest (first_name,last_name,email,phone) VALUES(?,?,?,?)";

        try (Connection conn = this.connection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // System.out.println("conn: " + conn); // add this line

            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNum);
            pstmt.executeUpdate();
            System.out.println("Guest Has Been Added to Database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Get all available rooms based on the parameters set by roomSearch object
    public ResultSet getAvailableRooms(RoomSearch roomSearch) {
        // Create ResultsController Object to send result set to ResultsController.java
        ResultsController resultsController = new ResultsController();
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
            
            int num = 1;
            ResultsController r1 = new ResultsController();
            ObservableList<ResultSet> results = FXCollections.observableArrayList();
            while (rs.next()) {
                
                int rsRoomNo = rs.getInt("room_No");
                int rsSize = rs.getInt("size");
                boolean rsSmoking = rs.getBoolean("smoking");
                boolean rsPet = rs.getBoolean("pet");
                double rsPrice = rs.getDouble("price");
                
                String x = ""+rsRoomNo+" "+rsSize+" "+rsSmoking+" "+rsPet+" "+rsPrice;
                //ADD THESE VARIABLES TO OBSERVABLESTRING ARRAY
                r1.addString(x);
                r1.refreshList();
                /*System.out.println("\n\nResult Set " + num);
                System.out.println("Room No: " + rsRoomNo);
                System.out.println("Size: " + rsSize);
                System.out.println("Smoking: " + rsSmoking);
                System.out.println("Pet: " + rsPet);
                System.out.println("Price: " + rsPrice);*/
                
                //r1.addIntToList(rsRoomNo);
                //r1.setResultsData(rs);
                
                
                //System.out.println(rs.toString());
                results.add(rs);
                num++;
            }
            r1.printResults();
            
            //System.out.println("\n" + num + " Available Rooms\n");
            return rs;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return rs;
    }

    
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("home"), 1000, 1000);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
        App app = new App();

    
        /* 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String fName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lName = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter phone number: "); // HARVI- Parsed as string to resolve a mismatch exception.
        String phoneNum = sc.nextLine();
        app.insert(fName, lName, email, phoneNum);
        
        System.out.println("Done!");
        sc.close();
        */
    }
}