package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class will help establish a connection to our DB
public class ConnectionUtil {
    
    private static Connection con;

    // Private constructor for security; no one will be able to make a Connection Object
    private ConnectionUtil() {
        con = null;
    }

    // Method to establish a connection to the DB or give
    // the existing connection
    public static Connection getConnection() {

        // Find out if a connection exists
        try {
            if (con != null && con.isClosed()) {
                return con;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Obtain System variables for DB connection
        String url, user, pass;

        url = System.getenv("url");
        user = System.getenv("user");
        pass = System.getenv("pass");

        // Set up the connection to the database
        try {
            con = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Incorrect URL or password entered.");
        }

        return con;
    }   
}
