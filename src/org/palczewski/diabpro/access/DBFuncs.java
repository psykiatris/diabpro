/*
 * Copyright (c) 2018. Author: Patrick Palczewski <psykiatris@gmail.com>. Licensed under GPL 3. See LICENSE for details.
 */

package org.palczewski.diabpro.access;
/*
Once connected to database, these functions will allow creation of
initial database, editing fields in database.
 */


import java.sql.*;

public class DBFuncs {
    // Set up final fields for connection
    // Change user and pw info to your own system.

    private static final String url =
            "jdbc:mysql://localhost:3306/diabetes" +
                    "?verifyServerCertificate" +
                    "=false" +
                    "&useSSL=true";
    private static final String DIABPRO = "diabpro";
    // See README on setting this up in mySQL, so that code can be
    // worked on.
    private static final String user = DIABPRO;
    private static final String pw = DIABPRO;
    private static Connection con;
    private static Statement stmt;

    public DBFuncs() {
        // Creates instance
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
            System.out.println("Connected to server.");

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database.");
        }


    }


    public static void createDB(String db) {
        // Check if connection is open
        if(!isOpen()) {
            // If not open, open it.
            doConnect();
        }
        // TODO: 3/15/19 Check if db exists. If yes, return, if not, go ahead and create.

        // Set up new database.
        System.out.println("Creating database " + db + ".");
        try {
            stmt = con.createStatement();
            String sql = "create database " + db;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error creating database " + e.getMessage());
        }
        System.out.println("Database " + db + " ready for input.");


    }

    public void listDB() {
        // Check if con is open or not.
        if(!isOpen()) {
            // If not, connect.
            doConnect();
        }

        try {
            stmt = con.createStatement();
            String list = "show databases";
            try (ResultSet rs = stmt.executeQuery(list)) {
                System.out.println("List of databases on mySQL:");
                int i = 1;
                while (rs.next()) {
                    System.out.println(i + ": " + rs.getString(1));
                    i++;
                }
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error processing statement" + e.getMessage());
        }

    }

    public void createTables(String dbName) {
        // Check if connected
        if(!isOpen()) {
            doConnect();
        }

        // Change to database
        changeDB("diabetes");
        // Create table
        try {
            stmt = con.createStatement();
            String table =
                    "nutrition" + (int) (Math.random() * 1000.0);
            String createTable = "create table " + table + "(id integer, " +
                    "name Text(32))";
            stmt.execute(createTable);

            /*
            Temporary code
             */
            // Enter stuff
            for(int i = 0; i < 255; i++) {
                String addRow =
                        "insert into " + table + " values(" + (int)(Math.random() * 32767) + ",'Text Value" + Math.random() + "')";
                stmt.execute(addRow);
            }
        } catch (SQLException e) {
            System.out.println("Error processing statement" + e.getMessage());
        }





    }

    public void deleteDB() {
        /*
        Unsure if this will really be needed, but put it in just in case.
        Will delete specified db.
         */
    }



    public void listTables() {
        // If not connected, connect.
        if(!isOpen()) {
            doConnect();
        }

        /*
        Change to the database prior to running this method. Will list
        the table(s) within the db.
         */
        try {
            stmt = con.createStatement();
            try(ResultSet rs = stmt.executeQuery("show tables")) {
                int i = 1;
                System.out.println("Table list:");
                while(rs.next()) {
                    System.out.println(i + ": " + rs.getString(1));
                    i++;
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error processing listTable(): " + e.getMessage());
        }

    }

    public void changeDB(String dbName) {
        // After connect, change to specifi db.
        if(!isOpen()) {
            doConnect();
        }

        /*
        Switch to database in dbName.
         */
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("use " + dbName);
            System.out.println("Changed to " + dbName + " database.");
        } catch (SQLException e) {
            System.out.println("Error changing db: " + e.getMessage());
        }


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
