/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;
/*
Once connected to database, these functions will allow creation of
initial database, editing fields in database.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFuncs {
    // Set up final fields for connection
    // Change user and pw info to your own system.

    private static final String url =
            "jdbc:mysql://localhost:3306/?verifyServerCertificate=false&useSSL=true";
    private static final String DIABPRO = "diabpro";
    // See README on setting this up in mySQL, so that code can be
    // worked on.
    private static final String user = DIABPRO;
    private static final String pw = DIABPRO;
    private static Connection con = null;
    private static Statement stmt = null;

    public DBFuncs() {
    }

    // Connect
    public static void doConnect() {
        // If already connected...
        if(con != null) return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*
            Per inspection, DriverManager has been superseded by javax
            .sql.Datasoure. (Need to update)
             */
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connected");

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }
        // pass to createDB
        createDB(con, "diabetes");
    }


    public static void createDB(Connection conn, String db) {
        // Check if connection is open
        if(!isOpen()) {
            // If not open, open it.
            doConnect();
        }

        // Set up new database.
        System.out.println("Creating database " + db + ".");
        try {
            stmt = conn.createStatement();
            String sql = "create database " + db;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error creating database " + e.getMessage());
        }
        System.out.println("Database " + db + " ready for input.");


    }

    public static void editDB() {
        // Make changes to db
        // TODO: 8/19/18 - Edit db
    }
    // When done
    // TODO: 8/19/18 Move doCloase function here, if can't call it.

    public static void doClose() {
        if(con != null) {
            try {
                con.close();
                System.out.println("Closed connection");
            } catch (SQLException e) {
                System.out.println("Error in closing database.");
            }
        }

    }

    // I put this in if I need a way
    // to check if database is open or not.
    // Will remove if unnecessary
    public static boolean isOpen() {
        boolean ans;

        ans = con != null;

        return ans;

    }

    public final String toString() {
        return "This class manaages connecting to database.";
    }

}
