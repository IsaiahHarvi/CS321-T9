
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SqliteJDBC {
    
    private Connection connection(){
        
        Connection connect = null; 
        String url = "jdbc:sqlite:Hotel.db";                        //file location
            // /Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/java
        try{
            Class.forName("org.sqlite.JDBC");               //connect to JDBC
            connect = DriverManager.getConnection(url);
        } 
        catch(ClassNotFoundException e){
            System.out.println("Connection to DB failed! DB not found! \n");   //add error msg
        }
        catch(SQLException ex){
            System.out.println("Connection to DB failed! SQL exception thrown! \n");
        }
        finally {
            try{
                if (connect != null) connect.close();
            }
            catch (SQLException exc){
                System.out.println("Closing connection failed! ");
            }
            
        }
        return connect;
    } 
    
    public void insert(String fName, String lName, String email, String phoneNum) {
        String sql = "INSERT INTO Guests(f_name,l_name,email,phone_num) VALUES(?,?,?,?)";

        try (Connection conn = this.connection(); 
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, email);
            pstmt.setString(4, phoneNum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
        public static void main(String[] args) {
        SqliteJDBC app = new SqliteJDBC();
        Scanner sc = new Scanner(System.in);
           // System.out.println("\n Successfully connected to SQlite database. enter information and enter a blank space to exit.\n");
            while (true) {
                System.out.print("Enter first name: ");
                String fName = sc.nextLine();
                if (fName.isBlank()) {
                    break;
                }
                System.out.print("Enter last name: ");
                String lName = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter phone number: "); // HARVI- Parsed as string to resolve a mismatch exception.
                String phoneNum = sc.nextLine();
                sc.nextLine();

                app.insert(fName, lName, email, phoneNum);
            }

            sc.close();
    }
}
    
    

