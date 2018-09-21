/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.ppalczewski.diabpro.access;
/*
Once connected to database, these functions will allow creation of
initial database, editing fields in database.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFuncs {



    // Set up final fields for connection
    // Change user and pw info to your own system.
    private static final String url = "jdbc:mysql://localhost:3306/test" +
            "?verifyServerCertificate=false&useSSL=true";
    private static final String DIABPRO = "diabpro";
    // See README on setting this up in mySQL, so that code can be
    // worked on.
    private static final String user = DIABPRO;
    private static final String pw = DIABPRO;
    private static Connection con;

    public DBFuncs() {
    }

    // Connect
    public static void doConnect() {
        if(con != null) return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*
            Per inspection, DriverManager has been superseded by javax
            .sql.Datasoure. (Need to update)
             */
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void createDDB() {
        // Check if database is open
        if(!DBFuncs.isOpen())
            return;
        // Set up new database.
        // TODO: 8/19/18 Create mySQL db

    }

    public void editDB() {
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
                e.printStackTrace();
            }
        }

    } // End doClose()

    // I put this in if I need a way
    // to check if database is open or not.
    // Will remove if unnecessary
    public static boolean isOpen() {
        boolean ans;

        if(con == null) {
            ans = false;
        } else {
            ans = true;
        }

        return ans;

    }

    public String toString() {
        return "This class manaages connecting " + "to database.";
    }

} // end class
