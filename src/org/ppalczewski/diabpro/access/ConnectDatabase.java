/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.ppalczewski.diabpro.access;

/*
This file will connect the diary to the databse. Going to use mySQL.

The date will be the key for each entry.
Fields will be:
* Glucose readings
* Nutrition stats
* Diary notes
 */
// Imports
import com.sun.xml.internal.bind.v2.TODO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    // Set up connection
    // TODO: 8/17/18 Set up way to get user info

    // using established test database for now
    // Change to the diabetespro database when done
    private static final String url = "jdbc:mysql://localhost:3306/test" +
            "?verifyServerCertificate=false&useSSL=true";
    private static final String user = "root";
    private static final String pw = "Pe99er@1";
    public static Connection con;

    public static void doConnect() {
        if(con != null) return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Make sure database connection closed
    public static void doClose() {
        if(con != null) {
            try {
                con.close();
                System.out.println("Closed connection");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    } // End close()

    public static void createDatabase() {
        // ...
    }

    public static void editDatabase() {
        // ...
    }

    // I put this in if I need a way
    // to check if database is open or not.
    // Will remove if unnecessary
    public static boolean isOpen() {
        boolean ans;

        if(con == null)
            ans = false;
        else
            ans = true;

        return ans;

    }

    public String toString() {
        return "This class manaages connecting " + "to database.";
    }


} // End class

