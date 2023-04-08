package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;


    // Recieve RoomSearch object from FiltersController.java
    public void recieveRoomSearch(RoomSearch roomSearch) {
        System.out.println("Recieved RoomSearch Object.");
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Get all available rooms based on the parameters set by roomSearch object
    public void getAvailableRooms() {
        // Create ResultsController Object to send result set to ResultsController.java
        ResultsController resultsController = new ResultsController();

        try (Connection conn = this.connection()) {
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(
                "SELECT r.room_No, r.size, r.smoking, r.pets, r.price FROM Room r\n" +
                "JOIN Hotel h ON r.hotel_No = h.hotel_No\n" +
                "WHERE h.name = ?\n" +
                "AND r.smoking = 1\n" +
                "AND r.pets = 1\n" +
                "AND r.size > ?\n" +
                "AND r.price >= ? AND r.price <= ?\n" +
                "AND NOT EXISTS (\n" +
                    "SELECT *\n" +
                    "FROM Booking b\n" +
                    "WHERE b.hotel_No = r.hotel_No AND b.room_No = r.room_No\n" +
                    "AND b.check_in_date <= ? AND b.check_out_date > ?\n" +
                ")");

            /* 
            Debug Option to Iterate through the ResultSet
            int limit = 0;
            while (rs.next() and limit < 30) {
                int id = rs.getInt("room_No");
                int size = rs.getInt("hotel_No");
                System.out.print(id + " " + size + " ");
                limit++;
            }
            */

            // Send ResultSet to ResultsController.java
            resultsController.recieveResultSet(rs);

            rs.close();
            stmnt.close();
            // Maybe conn.close() here? - HARVI


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("filters"), 1000, 1000);
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