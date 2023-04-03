package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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
    }
}