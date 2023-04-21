package com.example.hotel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App where main is located with FX start functions
 * 
 * @author caseybramlett
 */
public class App extends Application {
    private static Scene scene;
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

    }
        /**
         * function to add new guest into database 
         * @param fName guest first name
         * @param lName guest last name
         * @param email guest email
         * @param phoneNum guest phone number
         */
    public void insert(String fName, String lName, String email, String phoneNum) {
        String sql = "INSERT INTO Guest (first_name,last_name,email,phone) VALUES(?,?,?,?)";

        try (Connection conn = this.connection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
    /**
     * function to create new reservation
     * @param guestNo guest number
     * @param hotelNo hotel number
     * @param roomNo room number - related to hotel number
     * @param checkIn check in date for reservation
     * @param checkOut check out date for reservation
     */
    public void addRes(long guestNo, int hotelNo, int roomNo, String checkIn , String checkOut){
        String sql = "INSERT INTO Booking (guest_No,hotel_No,room_No,check_in_date,check_out_date) VALUES (?,?,?,?,?)";
        
        try (Connection conn = this.connection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // System.out.println("conn: " + conn); // add this line

            pstmt.setLong(1, guestNo);
            pstmt.setInt(2, hotelNo);
            pstmt.setInt(3, roomNo);
            pstmt.setString(4, checkIn);
            pstmt.setString(5, checkOut);
            pstmt.executeUpdate();
            System.out.println("Reservation has been added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
        /**
         * This function  is used several times through out the program to connect to the database
         * @return connection to database
         */
    private Connection connection() {
        Connection connect = null;
        String url = ("jdbc:sqlite:" + new File("src//main//java//Database//Hotel.db").getAbsolutePath());
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
}